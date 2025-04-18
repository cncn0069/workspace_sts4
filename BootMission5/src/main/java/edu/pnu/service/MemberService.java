package edu.pnu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	
	private LogDao logDao;
	
	Map<String, Object> map;
	
	
	public MemberService() {
		// TODO Auto-generated constructor stub
		map = new HashMap<>();

	}

	public List<MemberVO> getAllMembers() {
		
		map = dao.getAllMembers();
		logDao.addLog(map);
		
		return (List<MemberVO>) map.get("lists");
			
	}

	public MemberVO getMember(Integer id) {

		map = dao.getMember(id);
		logDao.addLog(map);
		
		return (MemberVO) map.get("list");

	}

	public int addMember(MemberVO memberVO) {
		
		map = dao.addMember(memberVO);
		logDao.addLog(map);
		
		return (int) map.get("result");
	}
	
	

	public int updateMember(MemberVO memberVO) {

		
		map = dao.updateMember(memberVO);
		logDao.addLog(map);
		
		return (int) map.get("result");
	}
	
	public int removeMember(Integer id) {
		
		map = dao.deleteMember(id);
		logDao.addLog(map);
		
		return (int) map.get("result");
	}
	
	@Autowired
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	

}
