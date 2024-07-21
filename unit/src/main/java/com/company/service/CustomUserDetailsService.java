package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.MemberVO;
import com.company.mapper.JoinMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	@Setter(onMethod = @__({@Autowired}))
	private JoinMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + username);
		MemberVO vo = new MemberVO();
		
		try { vo = mapper.read_security(username); }
		catch (Exception e) { e.printStackTrace(); }

		log.warn("queried by member mapper : " + vo);

		return vo == null ? null : new CustomUser(vo);
	}
}