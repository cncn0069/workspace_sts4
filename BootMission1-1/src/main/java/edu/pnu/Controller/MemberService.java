package edu.pnu.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	List<MemberVO> list; 
	
	public MemberService() {
		list = new ArrayList<MemberVO>();
		
		for(int i = 0; i < 10;i++) {
			list.add(MemberVO.builder()
					.id(i)
					.name(i +"test")
					.pass("1234")
					.regidate(new Date())
					.build());
		}
	}
	
	public List<MemberVO> getList() {
		return list;
	}
}
