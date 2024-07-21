package com.company.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.AuthVO;
import com.company.dto.JoinDto;
import com.company.dto.MemberVO;
import com.company.mapper.JoinMapper;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class JoinServiceImpl implements JoinService{
	@Autowired JoinMapper joinmapper;
	

	@Override
	public List<JoinDto> selectall() {
		return joinmapper.selectall();
	}

	@Override
	public int insert(JoinDto dto) {
		try { dto.setJip(InetAddress.getLocalHost().getHostName()); } catch (UnknownHostException e) { e.printStackTrace(); }
		return joinmapper.insert(dto);
	}

	

	@Override
	public JoinDto selectEmail(String dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JoinDto selectTwo(JoinDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int idCheck(String dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int emailCheck(String dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JoinDto selectTwo2(JoinDto dto) {
		return joinmapper.selectTwo2(dto);
	}

	@Override
	public int update(JoinDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update2(boolean bool, String dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int passwordUpdate(JoinDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(JoinDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int salseupdate(JoinDto dto) {
		return joinmapper.salseupdate(dto);
	}
	
	@Override
	public JoinDto selectNic(JoinDto dto) {
		return joinmapper.selectNic(dto);
	}
	@Override
	public MemberVO read_security(String userid) {
		return joinmapper.read_security(userid);
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		return joinmapper.insertMember(memberVO);
	}

	@Override
	public int insertAuth(AuthVO AuthVo) {
		return joinmapper.insertAuth(AuthVo);
	}

	@Override
	public MemberVO selectUserid(String userid) {
		return joinmapper.selectUserid(userid);
	}

	@Override
	public AuthVO selectAuthid(String userid) {
		return joinmapper.selectAuthid(userid);
	}

	@Override
	public int updateAuth(AuthVO AuthVO) {
		return joinmapper.updateAuth(AuthVO);
	}

	@Override
	public JoinDto joinInfo(String userid) {
		return joinmapper.joinInfo(userid);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return joinmapper.updateMember(memberVO);
	}

	
}
	
	
	

