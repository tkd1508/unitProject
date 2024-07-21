package com.company.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.company.dto.JoinDto;
import com.company.dto.PagingDto;
import com.company.dto.TalentsalesDto;
import com.company.mapper.TalentSalesMapper;

import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class TalentSalesServiceImpl implements TalentSalesService{
	@Autowired TalentSalesMapper TalentSalemapper;
	
	
	@Override
	public List<TalentsalesDto> list() { return TalentSalemapper.list(); }

	/* @Transactional
	@Override
	public BoardDto readOne(BoardDto dto) { boardmapper.updateBhit(dto); return boardmapper.readOne(dto); }


	@Override
	public int updateBhit(BoardDto dto) { return boardmapper.updateBhit(dto); }
	 */
	
	@Override
	public int insert(TalentsalesDto dto , MultipartFile file, HttpServletRequest request ) {
		// ip, file > insert
		
		try { dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName()); } catch (UnknownHostException e) { e.printStackTrace(); }
		if(file.getOriginalFilename().length() !=0) { 
		try { dto.setSalesImg(fileupload( file.getOriginalFilename(), request, file.getBytes())); } catch (Exception e) { e.printStackTrace(); } 
		}
		// System.out.println(dto.getSalesImg());
		// System.out.println("............."+dto.getUserNum());
		return TalentSalemapper.insert(dto);
	}
	
	

	public String fileupload( String originalFilename, HttpServletRequest request, byte[] fileDate ) throws IOException {
		// 1. 파일 중복되지 않게 고유 키 설정
		String saveName = UUID.randomUUID().toString() + "_" + originalFilename;
		// 2. 파일업로드
		// String path = "C:\\upload"; // 연습용
		String path = request.getSession().getServletContext().getRealPath("/")+"resources/upload/"; //호스팅용
		File target = new File(path,saveName); // File(파일경로, 파일이름)
		FileCopyUtils.copy(fileDate, target);
		return saveName;
		
	}
/*
	@Override
	public int creat(TalentSalesDto dto, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public List<TalentsalesDto> readMyselect(TalentsalesDto dto) {
		return TalentSalemapper.readMyselect(dto);
	}

	@Override
	public TalentsalesDto readOne(TalentsalesDto dto) {
		return TalentSalemapper.readOne(dto);
	}
	
	@Override
	public TalentsalesDto selectOne(TalentsalesDto dto) {
		return TalentSalemapper.selectOne(dto);
	}
	
	@Override
	public int updateBhit(TalentsalesDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TalentsalesDto dto, MultipartFile file, HttpServletRequest request) {
		dto.setSalesImg(request.getParameter("pre_file"));
		try { dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName()); } catch (UnknownHostException e) { e.printStackTrace(); }
		if(file.getOriginalFilename().length() !=0) {
		try { dto.setSalesImg(fileupload( file.getOriginalFilename(), request, file.getBytes())); } catch (Exception e) { e.printStackTrace(); } 
		}
		return TalentSalemapper.update(dto);
	}
	
	/*
	@Override
	public int update(BoardDto dto, MultipartFile file, HttpServletRequest request) {
		dto.setBfile(request.getParameter("prev_file"));
		if(file.getOriginalFilename().length() !=0) {
		try { dto.setBfile( fileupload( file.getOriginalFilename(), request, file.getBytes())); } catch (Exception e) { e.printStackTrace(); }
		}
		return boardmapper.update(dto);
	}

	@Override public int delete(BoardDto dto) { return boardmapper.delete(dto); }
	 */
	
	@Override
	public int delete(TalentsalesDto dto) {
		
		return TalentSalemapper.delete(dto);
	}
/*
	@Override
	public int insertsales(TalentSalesDto dto) {
		log.info("재능 판매 글쓰기");
		try {
			dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return TalentSalemapper.insertsales(dto);
	}

	@Override
	public int insertImg(TalentSalesDto dto) {
		log.info("재능 판매 글쓰기-이미지");
		try {
			dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return TalentSalemapper.insertImg(dto);
	}

	@Override
	public int insertMaincategory(TalentSalesDto dto) {
		log.info("재능 판매 글쓰기-이미지");
		try {
			dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return TalentSalemapper.insertMaincategory(dto);
	}

	@Override
	public int insertSubcategory(TalentSalesDto dto) {
		log.info("글쓰기1");
		try {
			dto.setSalesJoinIp(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return TalentSalemapper.insertSubcategory(dto);
	}*/

	@Override
	public int listSum() {
		return TalentSalemapper.listSum();
	}

	@Override
	public List<TalentsalesDto> list10(int pstartno) {
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		param.put("pstartno", pstartno);
		param.put("onepageList", 20);
		return TalentSalemapper.list10(param);
	}

	@Override
	public ArrayList abc() {
		// TODO Auto-generated method stub
		
		ArrayList bbb = null;
		
		String[] arr1 = {"a1", "a2", "a3", "a4", "a5", "a6"};
		String[] arr2 = {"a6", "a5", "a4", "a3", "a2", "a1"};
		
		for(int i =0; i<arr1.length; i++) {
			
			
			for(int j =0; j<arr2.length; j++) {
				System.out.println(arr1[i].toString().equals(arr2[j].toString()) + "test1");
					
			}
			
			
		}
		
		
		
		
		return null;
	}


	
	

	
}
	
	
	

