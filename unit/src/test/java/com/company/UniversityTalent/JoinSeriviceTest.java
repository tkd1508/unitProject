package com.company.UniversityTalent;

import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.MemberVO;
import com.company.mapper.JoinMapper;
import com.company.service.JoinService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class JoinSeriviceTest {
	// @Autowired TalentSalesService service;
	@Autowired JoinMapper Mapper;
	@Autowired JoinService service;
	/*
	 @Test public void testList() {log.info("........."+Mapper.selectall());}*/
	
	 /*
	 @Test public void testinsert() throws UnknownHostException { 
		 MemberVO dto = new MemberVO(); 
		 dto.setUserid("aaa3");
		 dto.setUserpw("123");
		 log.info("........."+Mapper.insertMember(dto));
		 }
	 
	 @Test public void testinsert2() throws UnknownHostException { 
		 AuthVO dto = new AuthVO(); 
		 dto.setUserid("aaa");
		 dto.setAuth("Role_A");
		 log.info("........."+Mapper.insertAuth(dto));
		 }
	
	 @Test public void testSelect3() { 
		  log.info("........."+Mapper.read_security("김상욱"));}
	 */
	 @Test public void testSelect() { 
		  JoinDto dto = new JoinDto();
		  dto.setJnicname("김상욱");
		  log.info("........."+service.selectNic(dto));}
		  
	/*
	 @Test public void testSelect3() { 
		  log.info("........."+Mapper.joinInfo("김상욱"));}
	 */
	/*
	@PreAuthorize("isAnoymous()")
	@Test public void testSelect() { 
		  log.info("........."+Mapper.selectUserid("fdasfa22"));}
	*/
	/*
	@Test public void testSelect() { 
		  log.info("........."+Mapper.selectAuthid("fdasfa22"));}
	*/
	 /*
	  @Test public void testSelect() { 
		  JoinDto dto = new JoinDto();
		  dto.setJnicname("김상욱");
		  dto.setSalesId("aaa");
		  dto.setSalesPw("1234");
		  log.info("........."+Mapper.salseupdate(dto));}
	 */
	/*
	@Test public void testUpdate() { 
		  AuthVO authVO = new AuthVO(); 
		  authVO.setUserid("member");
		  authVO.setAuth("ROLE_UNIVERSITY");
	  log.info("........."+Mapper.updateAuth(authVO));}
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
		 
	
	  @Test public void testDelete() { 
		  TalentSalesDto dto = new TalentSalesDto(); 
		  dto.setSalesNum(7); dto.setUserNum(1);
	  log.info("........."+Mapper.delete(dto));}
	
	
	  @Test public void testUpdate() { 
		  JoinDto dto = new JoinDto(); 
		  dto.setJnicname("김상욱");
	  
	  log.info("........."+Mapper.salseupdate(dto));}
	 */
}
