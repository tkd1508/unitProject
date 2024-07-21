package com.company.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.dto.TalentsalesDto;


public interface TalentSalesMapper {

	public List<TalentsalesDto> list();
	public int 		insert(TalentsalesDto dto);
	/*
	public int 		insertImg(TalentSalesDto dto);
	public int 		insertMaincategory(TalentSalesDto dto);
	public int 		insertSubcategory(TalentSalesDto dto);
	*/
	public List<TalentsalesDto>	readMyselect(TalentsalesDto dto);
	public TalentsalesDto		readOne(TalentsalesDto dto); // 마이페이지 >> 나의 서비스 등록 내역
	public TalentsalesDto		selectOne(TalentsalesDto dto); // 메인페이지 >> 서비스 상세페이지 구경가기
	public int 		update(TalentsalesDto dto);
	public int 		delete(TalentsalesDto dto);
	
	// public List<TalentsalesDto> paginglist();
	public int listSum();
	public List<TalentsalesDto> list10( HashMap<String, Integer> param );
	
	
	
}
//1. 전체 우유출력 - select * from milk order by mno desc
// List<MilkDto>	list()
//2. 우유 삽입 - insert into milk ( mname, mprice) values (?,?)
// int		create(MilkDto dto)	
//3. 유유 검색 - select * from milk where mno=?
// MilkDto	read(MilkDto dto)
//4. 유유 수정 - update milk set mprice+? where mno=?
// int 		update(MilkDto dto)
//5. 우유 삭제 - delete from milk where mno=?
// int		delete(MilkDto dto)


