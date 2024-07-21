package com.company.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private boolean enabled;
	private List<AuthVO> authList;
}