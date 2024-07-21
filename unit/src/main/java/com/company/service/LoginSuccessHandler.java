package com.company.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.company.dto.JoinDto;
import com.company.mapper.JoinMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired JoinService service;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		JoinDto dto = new JoinDto();
		JoinDto result = null;
		String resultmsg = "";
		
		
		log.warn("...........................LoginSuccessHandler : Login Success");
		
		List<String> roleNames = new ArrayList<String>();
		auth.getAuthorities().forEach(authority -> { roleNames.add(authority.getAuthority()); });
		
		log.warn("...........................LoginSuccessHandler : ROLE NAMES" + roleNames);
		
		//인증된 사용자의 정보를 추출 
	      CustomUser vo = (CustomUser)auth.getPrincipal();   
	      System.out.println(".................... 인증후=>"+vo);
	      System.out.println(".................... 인증후=>"+vo.getMember().getUserid());
	      request.setAttribute("salesid",  vo.getMember().getUserid());
	      System.out.println(request.getAttribute("salesid"));
	    
	      dto.setJnicname(vo.getMember().getUserid());
	      System.out.println("dto >>>> "+dto.getJnicname());
	      System.out.println("dao >>>> "+service.selectNic(dto));
	      
	      result = service.selectNic(dto);
	      
		if(roleNames.contains("ROLE_ADMIN")) { 
			request.getSession().setAttribute("salesid",  result.getSalesId());
			request.getSession().setAttribute("id",  result.getJemail());
			response.sendRedirect(request.getContextPath() + "/talentSales/main"); return; }
		if(roleNames.contains("ROLE_UNIVERSITY")) { 
			request.getSession().setAttribute("salesid",  result.getSalesId());
			request.getSession().setAttribute("userNum", result.getJno());
			request.getSession().setAttribute("id",  result.getJemail());
			response.sendRedirect(request.getContextPath() + "/talentSales/main"); return; }
		if(roleNames.contains("ROLE_NOMAL")) { 
			request.getSession().setAttribute("salesid",  result.getSalesId());
			request.getSession().setAttribute("userNum", result.getJno());
			request.getSession().setAttribute("id",  result.getJemail());
			response.sendRedirect(request.getContextPath() + "/talentSales/main"); return; }
		
		
		response.sendRedirect("/");
	}
}