package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.mapper.JoinMapper;

import lombok.extern.log4j.Log4j;

@RequestMapping("/security/*")
@Controller
@Log4j
public class SecurityController {
	@Autowired JoinMapper mapper;
	
	@GetMapping("/all") public void all() { } 

	@GetMapping("/member") public String member() { return "/security/member"; }
	@GetMapping("/admin") public String admin() { return "/security/admin"; }
	@GetMapping("/mylogin") public String mylogin() { return "/security/mylogin"; }
	@GetMapping("/accessError") public String accessError() { return "/security/accessError"; }
}