package com.company.dto;

import java.util.List;


import lombok.Data;

@Data

public class JoinDto {
	
// 회원가입 정보 - user 엄마 테이블
	private int jno;
	private String jemail;
	private String jpassward;
	private String jnicname;
	private String jphone_num;
	private String jjob;
	private String jdate;
	private String jip;
	private boolean jevent_ad_check;
	private boolean jcertification;
	private String salesId;
	
}
