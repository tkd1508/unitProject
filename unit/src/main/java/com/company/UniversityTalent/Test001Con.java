package com.company.UniversityTalent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.dto.TestDto;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class Test001Con {

	@RequestMapping("/basic001_ex/test001") public void test001() {           }
	@GetMapping("/basic001_ex/test002") public String test002() {return "/basic001_ex/test002";}
	@RequestMapping(value="/basic001_ex/test003", method= {RequestMethod.GET, RequestMethod.POST}) public String test003() {return "/basic001_ex/test003";}
	@GetMapping("/basic001_ex/paraForm001") public String paraForm001() {return "/basic001_ex/paraForm001";}
	@GetMapping("/basic001_ex/paraForm002") public String paraForm002() {return "/basic001_ex/paraForm002";}
	@GetMapping("/basic001_ex/paraForm002_1") public String paraForm002_1() {return "/basic001_ex/paraForm002_1";}
	
	
	
	@GetMapping("/para001")
	public String datadb1(@RequestParam("search") String search, Model model ) {
		model.addAttribute("search", search);
		return "/basic001_ex/para001";
	}
	@PostMapping("/para002")
	public String datadb2(TestDto dto, Model model ) {
		log.info("...TestDto"+dto);
		model.addAttribute("dto", dto);
		return "/basic001_ex/para002";
	}
	/*
	 * @RequestMapping("/ex01") public void ex01() { }
	 */
	
	
}
