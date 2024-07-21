package com.company.UniversityTalent;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DBCP002 {

	@Autowired
	private DataSource ds;

	@Test
	public void test() throws Exception{
		try {
		Connection conn = ds.getConnection();
		if (conn != null) {
			log.info("....2 : " + conn);
		}
		}catch(Exception e) {e.printStackTrace();}
		}
	


}
