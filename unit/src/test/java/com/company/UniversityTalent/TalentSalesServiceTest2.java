package com.company.UniversityTalent;

import java.net.UnknownHostException;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.TalentsalesDto;
import com.company.mapper.TalentSalesMapper;
import com.company.service.TalentSalesService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class TalentSalesServiceTest2 {
	// @Autowired TalentSalesService service;
	@Autowired TalentSalesService service;
	
	  
	 /*
	 @Test public void testinsert() throws UnknownHostException { 
		 TalentsalesDto dto = new TalentsalesDto(); 
		 dto.setUserNum(2); // 유저테이블 PK(로그인 닉네임) 
		 dto.setSalesNum(2); // 판매글테이블 PK - 유저테이블 FK(로그인 닉네임)
		 dto.setSalesTitle("testTitle"); dto.setSalesInfo("testInfo");
		 dto.setSalesCurriculum("test"); dto.setSalesPrice(1000);
		 dto.setSalesImg("k.jsp"); 
		 dto.setSalesJoinIp("123.123");
		 dto.setSalesMainCategory("문서 작업");
		 dto.setSalesSubCategory("녹취록 작성");
		 log.info("........."+Mapper.insert(dto));
		 }
	*/
	
	 
	 /*
	  @Test public void testSelect() { 
		  TalentsalesDto dto = new TalentsalesDto();
		  dto.setUserNum(1);
		  dto.setSalesNum(58);
		  log.info("........."+service.readOne(dto));}
	 */
	/*	
	  @Test public void testUpdate() { 
		  TalentSalesDto dto = new TalentSalesDto(); 
		  dto.setUserNum(1); // 유저테이블 PK(로그인 닉네임) 
			 dto.setSalesNum(7); // 판매글테이블 PK - 유저테이블 FK(로그인 닉네임)
			 dto.setSalesTitle("q"); dto.setSalesInfo("qr");
			 dto.setSalesCurriculum("qr"); dto.setSalesPrice(3000);
			 dto.setSalesImgTitle("qw.jsp"); 
			 dto.setSalesJoinIp("123.123");
			 dto.setSalesMainCategoryTitle("qw");
			 dto.setSalesSubCategoryTitle("qr");
	  
	  log.info("........."+Mapper.update(dto));}
		 
	*/
	/*
	  @Test public void testDelete() { 
		  TalentsalesDto dto = new TalentsalesDto(); 
		  dto.setSalesNum(49); dto.setUserNum(1);
	  log.info("........."+service.delete(dto));}
	 
	  @Test public void testList() {log.info("........."+service.list());}
	  */
	
	 @Test public void testList2() {
		  // 
	  
	  
	  service.list10(0);
	  
	  log.info(".......3.."+service);}
	  
	
}
