package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.Param;
import org.springframework.ui.Model;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.PagingDto;
import com.company.dto.TalentsalesDto;
import com.company.service.JoinService;
import com.company.service.TalentSalesService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/talentSales/*")
@Log4j
public class TalentSalesController {
	@Autowired TalentSalesService salesservice;
	@Autowired JoinService joinservice;
	
	// JSP >> 스프링 넘기기
	@RequestMapping(value = "/intro", method = RequestMethod.GET) 
	public String intro_get(JoinDto dto, Model model, @RequestParam(required = false) String param) {
		log.info("...intro"); System.out.println("/intro 입장 >>>>>>> "+param);
		
		
		ArrayList a = salesservice.abc();
		
		
		model.addAttribute("nicname", param);
		return "/sales/sales_intro";
		}
	
	// 마이페이지 >> 나의 서비스 등록 내역
	@RequestMapping(value = "/readMyselect", method = RequestMethod.GET) 
	public String readMyselect_get(TalentsalesDto dto, HttpSession session, Model modal) { 
		int userNum= (int) session.getAttribute("userNum");
		dto.setUserNum(userNum);
		//dto.setUserNum(1);
		modal.addAttribute("dto", salesservice.readMyselect(dto));
		return "/sales/sales_myread";
	}
		
	/*
		// 메인 판매페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String list_get(Model model) {
		log.info("...main");
		model.addAttribute("main", salesservice.list());
		return "/sales/sales_main";
	}
	*/
		
	// 메인 판매페이지 (paging 버전)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String list_get(@RequestParam(value="pstartno", defaultValue="0") int pstartno, Model model) throws Exception {
		log.info("...main + paging");
		model.addAttribute("main", salesservice.list10(pstartno));
		model.addAttribute("paging", new PagingDto(pstartno, salesservice.listSum()));
		
		return "/sales/sales_main";
	}
		
		
	// 메인 판매페이지 >> 랜덤 상세페이지
	@RequestMapping(value = "/selectOne", method = RequestMethod.GET) 
	public String selectOne_get(TalentsalesDto dto, Model modal) { 
		modal.addAttribute("dto", salesservice.selectOne(dto));
		return "/sales/sales_detail";
	}
	
	// 마이페이지 >> 나의 서비스 글 상세 내역
		@RequestMapping(value = "/readOne", method = RequestMethod.GET) 
		public String readOne_get(TalentsalesDto dto, HttpSession session, Model modal) { 
			System.out.println(session.getAttribute("userNum"));
			modal.addAttribute("dto", salesservice.readOne(dto));
			return "/sales/sales_detail";
		}
		
		
	// 판매글 등록페이지
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET) 
	public String insert_get(TalentsalesDto dto) { log.info("...insert_view");
	return "/sales/sales_insert";}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/insert", method = RequestMethod.POST) 
	public String insert_post(AuthVO authvo, TalentsalesDto dto, @RequestParam("file") MultipartFile file, HttpSession session, HttpServletRequest request, Model modal, RedirectAttributes rttr, Authentication auth) throws IOException {
		String result = "fail";
		System.out.println("insert 여기 통과");
		int userNum= (int) session.getAttribute("userNum");
		dto.setUserNum(userNum);
		if(salesservice.insert(dto, file, request) > 0) {result="DB - 판매 글 등록 성공";}
		/*rttr.addAttribute("success", result);
		rttr.addAttribute("dto", salesservice.readMyselect(dto));*/
		modal.addAttribute("success", result);
		modal.addAttribute("dto", salesservice.readMyselect(dto));
		return "/sales/sales_myread";
	} // 마이페이지로 넘기기 + session 유저 번호 설정하기
	
	@RequestMapping(value = "/update", method = RequestMethod.GET) 
	public String update_get(TalentsalesDto dto, Model model) {
		model.addAttribute("dto", salesservice.readOne(dto));
		return "/sales/sales_update"; 
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public String update_post(TalentsalesDto dto, MultipartFile file, HttpServletRequest request,RedirectAttributes rttr) {
	String result = "fail";
	if(salesservice.update(dto, file, request) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/talentSales/readMyselect?salesNum="+dto.getSalesNum();}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public String delete_get(TalentsalesDto dto, RedirectAttributes rttr, HttpSession session ) {
		String result = "fail";
		int userNum= (int) session.getAttribute("userNum");
		dto.setUserNum(userNum);
		System.out.println(">>>>>>>>> talentSales/delete : "+dto);
		
		if(salesservice.delete(dto) > 0) {result="성공";}
		rttr.addFlashAttribute("success", result);
		return "redirect:/talentSales/readMyselect";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
	// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	session.invalidate();
	
	return "/talentSales/main";
	}


	
	
	 /*
	@RequestMapping(value = "/delete", method = RequestMethod.POST) 
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
	String result = "fail";
	if(service.delete(dto) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/board/list";}
	 */
	/*
	@RequestMapping(value = "/insert", method = RequestMethod.POST) 
	public String create_post(TalentSalesDto dto, MultipartFile file, HttpServletRequest request,RedirectAttributes rttr) {
	String result = "fail";
	if(service.insertsales(dto) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/board/list";} // 마이페이지로 넘기기
	*/
	
	
	
	
	
	 
	
}
