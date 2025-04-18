package edu.pnu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {

	MemberDao dao;
	LogDao logDao;
	
	public MemberService() {
		// TODO Auto-generated constructor stub

		dao = new MemberDao();
		logDao = new LogDao();
	}

	public List<MemberVO> getAllMembers() {
		return dao.getAllMembers();
			
	}

	public MemberVO getMember(Integer id) {

		return dao.getMember(id);
	}

	public int addMember(MemberVO memberVO) {


		return dao.addMember(memberVO);
	}
	
	public int updateMember(MemberVO memberVO) {

		
		return dao.updateMember(memberVO);
	}
	
	public int removeMember(Integer id) {
		
		return dao.deleteMember(id);
	}

}
