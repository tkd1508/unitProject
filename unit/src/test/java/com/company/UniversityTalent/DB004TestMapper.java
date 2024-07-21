package com.company.UniversityTalent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mapper.TestMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DB004TestMapper {
	
	@Autowired
	private TestMapper testmapper;
	@Test
	public void testMapper() throws Exception{
		try {
		// log.info(".........4-1 : " + testmapper); 위 아래 뭔 차이이지?
		log.info(".........4-2 : " + testmapper.test());
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	
}
