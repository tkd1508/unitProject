package com.company.mapper;

import java.util.List;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.MemberVO;



public interface JoinMapper {

	public List<JoinDto> selectall(); // 관리자 페이지 -- 전체보기 뽑아서 값을 페이지로 던져줘야함으로 리스트 자료형을 사용한다.
	public int 		insert(JoinDto dto); // 회원가입 정보 insert 하는 거임
	public JoinDto		selectEmail(String dto); // 메인페이지 >> 서비스 상세페이지 구경가기
	public JoinDto		selectTwo(JoinDto dto); // 수정페이지에 기존 값을 던져주기 위해 Dto 설정값을 던져줘야함으로 자료형은 Dto	검색하기 위한 dao
	public int		idCheck(String dto); // 메인페이지 >> 서비스 상세페이지 구경가기
	public int		emailCheck(String dto); // 메인페이지 >> 서비스 상세페이지 구경가기
	public JoinDto		selectTwo2(JoinDto dto); // selectTwo랑 겹치네?
	public int 		update(JoinDto dto);
	public int 		update2(boolean bool, String dto); // emailCheck_update랑 겹치네?
	public int 		passwordUpdate(JoinDto dto);
	public int 		delete(JoinDto dto);
	
	public JoinDto		selectNic(JoinDto dto); // 수정페이지에 기존 값을 던져주기 위해 Dto 설정값을 던져줘야함으로 자료형은 Dto	검색하기 위한 dao
	public int 		salseupdate(JoinDto dto);
	
	public MemberVO read_security(String userid);
	public int insertMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public int insertAuth(AuthVO AuthVO);
	public MemberVO		selectUserid(String userid);
	public AuthVO		selectAuthid(String userid);
	public int		updateAuth(AuthVO AuthVO);
	public JoinDto joinInfo(String userid);
	
	
}

// String a = "select * from joinboard";
// String a = "insert into joinboard ( jemail, jpassward, jnicname, jphone_num, jjob, jip, jevent_ad_check) values (?,?,?,?,?,?,?)";
// String a = "select * from joinboard where jnicname = ?";
// String a = "select * from joinboard where jemail = ?";
// String a = "select * from joinboard where jemail = ? and jpassward = ? ";
// String a = "select count(*) from joinboard where jnicname = ?";	
/* String b = "update joinboard set jcertification =? where jemail=?";
   String a = "select count(*), jcertification from joinboard where jemail = ?"; */
// String a = "select * from joinboard where jemail = ? and jpassward = ? ";
// String a = "update joinboard set jjob = ? , jphone_num= ? , jevent_ad_check =? where jno=?";
// String a = "update joinboard set jcertification =? where jemail=?";
// String a = "update joinboard set jpassward = ? where jemail=?";
// String a = "delete from joinboard where jno = ? and jpassward = ?";


