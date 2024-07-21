package com.company.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.MemberVO;
import com.company.dto.PagingDto;
import com.company.dto.TalentsalesDto;
import com.company.service.JoinService;
import com.company.service.TalentSalesService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/join/*")
@Log4j
public class JoinController {
	@Autowired JoinService service;
	@Autowired TalentSalesService salesservice;
	
	
	// 판매자 등록하기 - 시큐리티 user 테이블에 인서트하기
	 @PreAuthorize("isAnoymous()") 
		@RequestMapping(value = "/salesjoin", method = RequestMethod.GET) 
		public String join_get(AuthVO authvo, MemberVO membervo, JoinDto dto, Model model, @RequestParam(required = false) String param) { 
		log.info("...join_view");
		dto.setJnicname(param);
		PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String result = "fail";
		System.out.println("/salesjoin 입장 >>>>>>> "+param);
		
		if(service.salseupdate(dto) > 0) { // 등록완료 되면서...
			if(service.selectUserid(service.selectNic(dto).getJnicname()) == null) { // user 테이블에 정보가 없으면 인서트 실행해라.
			membervo.setUserid(service.selectNic(dto).getJnicname()); // user 테이블에 id 넣고
			/* membervo.setUserpw(service.selectNic(dto).getJpassward()); */
			membervo.setUserpw(pwEncoder.encode(service.selectNic(dto).getJpassward())); // user 암호화된 비밀번호 넣고
			service.insertMember(membervo); } // user 테이블에 insert 찍기
			
			else if (service.selectUserid(service.selectNic(dto).getJnicname()) != null) {
			membervo.setUserid(service.selectNic(dto).getJnicname()); // user 테이블에 id 넣고
			membervo.setUserpw(pwEncoder.encode(service.selectNic(dto).getJpassward())); // user 암호화된 비밀번호 넣고	
			service.updateMember(membervo);}
		if(service.selectNic(dto).getJjob().equals("대학생")) { // job에 따라 auth값 설정 수정시 자종 업데이트 됨.
			authvo.setUserid(dto.getJnicname());
			authvo.setAuth("ROLE_UNIVERSITY");
			if(service.selectAuthid(authvo.getUserid())==null) {
			service.insertAuth(authvo);
			}
		}else if(service.selectNic(dto).getJjob().equals("admin")){
			authvo.setUserid(dto.getJnicname());
			authvo.setAuth("ROLE_ADMIN");
			if(service.selectAuthid(authvo.getUserid())==null) {
			service.insertAuth(authvo);
			}
		}else {
			authvo.setUserid(dto.getJnicname());
			authvo.setAuth("ROLE_NOMAL");
			if(service.selectAuthid(authvo.getUserid())==null) {
			service.insertAuth(authvo);
			}
			 }
			result  = "success";
		}
		
		model.addAttribute("result", result);
		return "/sales/sales_intro";}
	
	
	// 판매자 전용 로그인페이지 - 뷰
		@RequestMapping(value = "/saleslogin", method = RequestMethod.GET) 
		public String salselogin_get() { log.info("...salselogin_view");
		return "/join/sales_login";}
	
	/*
			<div class="form-group">
			<strong>권한</strong>
			<input type="checkbox" name="auth" value="ROLE_MEMBER" id="ROLE_MEMBER" onclick="clickCheck(this)"/>
			<label for="ROLE_MEMBER">일반 유저</label>
			<input type="checkbox" name="auth" value="ROLE_ADMIN" id="ROLE_ADMIN" onclick="clickCheck(this)"/>
			<label for="ROLE_ADMIN">관리자</label>
			</div>
			
			
			JoinDto result = null;
			
			PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
			memberVO.setUserpw(pwEncoder.encode(memberVO.getUserpw()));
			
			if(mapper.insertMember(memberVO) > 0) {
				mapper.insertAuth(authVO);
				result = "회원가입 성공!";
			}
			attributes.addAttribute("result", result);
			*/
			
		 // 회원가입 후 인트로로 던지기 로그인으로 던져도 될거 같기도 해.
	
	
		
			
		// 판매자 전용 로그인 - 권한 insert
		@RequestMapping(value = "/login_action", method = RequestMethod.POST) 
		public String login_action_post(MemberVO membervo, AuthVO authvo, @RequestParam(value="pstartno", defaultValue="0") int pstartno, TalentsalesDto salesdto, JoinDto dto, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
			String resultmsg = "";
			JoinDto result = null;
			String remember = request.getParameter("remember");
			
			System.out.println(dto);
			result = service.selectTwo2(dto);
			System.out.println(result);
			
			if(result != null && result.getJnicname().equals("admin")) { System.out.println("관리자 로그인 성공");
			System.out.println(result.getJnicname());
			session.setAttribute("id", result.getJemail()); 
			session.setAttribute("salesid", result.getJnicname());
			
				if(remember != null){  // 아이디기억하기를 체크했다면,
					Cookie cookie1 = new Cookie("id",result.getSalesId());
					Cookie cookie2 = new Cookie("remember", "checked");
					cookie1.setMaxAge(600); //  60초 뒤 사라짐.
					cookie2.setMaxAge(600);
					response.addCookie(cookie1);
					response.addCookie(cookie2); 
				} else { // 체크를 안헀다면,
					String cookie = request.getHeader("Cookie"); //쿠키를 불러와서
					if(cookie != null){ // 쿠키가 있다면
						Cookie[] cookies = request.getCookies(); // 배열화하고
						for(int i =0; i<cookies.length; i++){
							if(cookies[i].getName().equals("remember") || cookies[i].getName().equals("id")){
								cookies[i].setMaxAge(0); 
							response.addCookie(cookies[i]); // 브라우저에 다시 세팅을 해줘야한다.
							}
						}
					}
				}	// 쿠키 부분 : 관리자 로그인 성공시 쿠키 생성
				
			}else if(result != null && !(result.getJnicname().equals("admin"))){ 
				System.out.println("일반 로그인 성공");
				session.setAttribute("id", result.getSalesId()); 
				session.setAttribute("salesid", result.getJnicname());
				session.setAttribute("userNum", result.getJno());
				
				if(remember != null){  // 아이디기억하기를 체크했다면,
					Cookie cookie1 = new Cookie("id",result.getSalesId());
					Cookie cookie2 = new Cookie("remember", "checked");
					cookie1.setMaxAge(600); //  60초 뒤 사라짐.
					cookie2.setMaxAge(600);
					response.addCookie(cookie1);
					response.addCookie(cookie2); 
				} else { // 체크를 안헀다면,
					String cookie = request.getHeader("Cookie"); //쿠키를 불러와서
					if(cookie != null){ // 쿠키가 있다면
						Cookie[] cookies = request.getCookies(); // 배열화하고
						for(int i =0; i<cookies.length; i++){
							if(cookies[i].getName().equals("remember") || cookies[i].getName().equals("id")){
								cookies[i].setMaxAge(0); 
							response.addCookie(cookies[i]); // 브라우저에 다시 세팅을 해줘야한다.
							}
						}
					}
				}	// 쿠키 부분 : 일반 로그인 성공시 쿠키 생성
			}else if (result == null){
				resultmsg = "fail";
				request.setAttribute("result", resultmsg);
				System.out.println("아이디 비번 확인");
			}
			
			model.addAttribute("success", resultmsg);
			// modal.addAttribute("dto", salesservice.readMyselect(salesdto));
			//model.addAttribute("main", salesservice.list());
			model.addAttribute("main", salesservice.list10(pstartno));
			model.addAttribute("paging", new PagingDto(pstartno, salesservice.listSum()));
			return "/sales/sales_main";
		} // 마이페이지로 넘기기 + session 유저 번호 설정하기
	
	
	// 로그아웃 > jsp 로그인 페이지로 이동
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String main_get(HttpSession session) {
		log.info("...main");
		session.invalidate();
		return "/sales/sales_main";
	}
		
		
	/*	
	@RequestMapping(value = "/intro", method = RequestMethod.GET) 
	public String intro_get() {
		log.info("...intro"); 
		return "/sales/sales_intro";
		}
	
	
	
	
	
	// 메인 판매페이지 >> 상세페이지
	@RequestMapping(value = "/selectOne", method = RequestMethod.GET) 
	public String selectOne_get(TalentsalesDto dto, Model modal) { 
		System.out.println(".......selectOne 출력되는지 확인"+dto);
		System.out.println(".......selectOne1_test"+service.selectOne(dto));
		modal.addAttribute("dto", service.selectOne(dto));
		System.out.println(".......selectOne2"+service.selectOne(dto));
		return "/sales/sales_detail";
	}
	
	// 판매자 전용 로그인페이지
		@RequestMapping(value = "/salselogin", method = RequestMethod.GET) 
		public String salselogin_get() { log.info("...insert_view");
		return "/sales/sales_login";}
		
		
	// 판매글 등록페이지
	@RequestMapping(value = "/insert", method = RequestMethod.GET) 
	public String insert_get(TalentsalesDto dto) { log.info("...insert_view");
	
	return "/sales/sales_insert";}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST) 
	public String insert_post(TalentsalesDto dto, @RequestParam("file") MultipartFile file, HttpServletRequest request, Model modal) throws IOException {
		String result = "fail";
		//System.out.println(request.getParameter("salesTitle"));
		
		if(service.insert(dto, file, request) > 0) {result="DB - 판매 글 등록 성공";}
		System.out.println("..................insert_test "+dto);
		modal.addAttribute("success", result);
		modal.addAttribute("dto", service.readMyselect(dto));
		return "/sales/sales_myread";
	} // 마이페이지로 넘기기 + session 유저 번호 설정하기
	
	// 마이페이지 >> 나의 서비스 등록 내역
	@RequestMapping(value = "/readOne", method = RequestMethod.GET) 
	public String readOne_get(TalentsalesDto dto, Model modal) { 
		System.out.println(".......출력되는지 확인"+dto);
		System.out.println(".......readOne1_test"+service.readOne(dto));
		modal.addAttribute("dto", service.readOne(dto));
		System.out.println(".......readOne2"+service.readOne(dto));
		return "/sales/sales_detail";
	}
	
	*/
	/*
	@RequestMapping(value = "/insert", method = RequestMethod.POST) 
	public String create_post(TalentSalesDto dto, MultipartFile file, HttpServletRequest request,RedirectAttributes rttr) {
	String result = "fail";
	if(service.insertsales(dto) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/board/list";} // 마이페이지로 넘기기
	*/
	
	/*
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET) 
	public String update_get(BoardDto dto, Model model) {
		model.addAttribute("dto", service.readOne(dto));
		return "board/update"; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public String update_post(BoardDto dto, MultipartFile file, HttpServletRequest request,RedirectAttributes rttr) {
	String result = "fail";
	if(service.update(dto, file, request) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/board/readOne?bno="+dto.getBno();}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET) public void delete_get(BoardDto dto) { }
	
	 
	@RequestMapping(value = "/delete", method = RequestMethod.POST) 
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
	String result = "fail";
	if(service.delete(dto) > 0) {result="성공";}
	rttr.addFlashAttribute("success", result);
	return "redirect:/board/list";}
	 */
	 
	
}
