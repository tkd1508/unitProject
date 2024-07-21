package com.company.UniversityTalent;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class JDBC003 {
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test2() throws Exception{
		try {
		Connection conn = ds.getConnection();
		SqlSession session = sqlFactory.openSession();
			log.info("....3-1 : " + sqlFactory);
			log.info("....3-2 : " + session);
		if (conn != null) {	
			log.info("....3-3 : " + conn);
		}
		}catch(Exception e) {e.printStackTrace();}
		}


}
