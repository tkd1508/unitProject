package com.company.UniversityTalent;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBC001 {
	@Test
	public void testConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/popol?useSSL=false", "root",
					"1234");
			if (conn != null) {
				log.info("....1 : " + conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
