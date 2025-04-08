package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list;
	
	public MemberService(){
		list = new ArrayList<>();
		
		for(int i =1; i <= 10; i++) {
			list.add(MemberVO.builder()
					.id(i)
					.name("name" + i)
					.pass("pass" + i)
					.regidate(new Date())
					.build());
		}
	}
	
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return list;
	}
}
