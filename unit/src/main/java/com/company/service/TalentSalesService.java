package com.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.dto.JoinDto;
import com.company.dto.TalentsalesDto;


public interface TalentSalesService {
	public List<TalentsalesDto> list();

	public int insert(TalentsalesDto dto , MultipartFile file, HttpServletRequest request );
	/*
	public int insertsales(TalentSalesDto dto);
	public int insertImg(TalentSalesDto dto);
	public int insertMaincategory(TalentSalesDto dto);
	public int insertSubcategory(TalentSalesDto dto);
	*/
	public List<TalentsalesDto> readMyselect(TalentsalesDto dto);
	public TalentsalesDto readOne(TalentsalesDto dto);
	public TalentsalesDto selectOne(TalentsalesDto dto);
	public int updateBhit(TalentsalesDto dto);
	public int update(TalentsalesDto dto, MultipartFile file, HttpServletRequest request );
	public int delete(TalentsalesDto dto);
	
	
	// public List<TalentsalesDto> paginglist();
	public int listSum();
	public List<TalentsalesDto> list10( int pstartno );
	
	public ArrayList abc();
		
}
