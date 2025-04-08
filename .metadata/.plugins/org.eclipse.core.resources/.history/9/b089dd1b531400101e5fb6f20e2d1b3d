package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

// rest 처리 컨트롤러
@RestController
public class MemberController2 {
	
	MemberService service;
	
	public MemberController2() {
		//리스트 객체 생성
		service = new MemberService();
		
	}
	
	//S
	@GetMapping("/members2")
	public List<MemberVO> getAllMember(){
		return service.getList();
	}
	
	//S
	@GetMapping("/member2")
	public MemberVO getElementById(Integer id) {
		
		
		return service.getList().get(id); 
	}
	
	
	
}
