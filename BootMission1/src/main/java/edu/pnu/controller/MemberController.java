package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	MemberService service;
	
	public MemberController() {
		service = new MemberService();
	}
	
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return service.getList();
	}
	
	@GetMapping("/member")
	public MemberVO getMemberById(Integer id) {
		for(MemberVO m : service.getList()) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	//C
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		if(getMemberById(memberVO.getId()) != null) {
			System.out.println(memberVO.getId() + "이미 존재합니다.");
			
			return null;
		}
		
		memberVO.setRegidate(new Date());
		service.getList().add(memberVO);
		return memberVO;
	}
	
	//U
	@PutMapping("/member")
	public int updateMember( MemberVO memberVO) {
		//TODO: process POST request
		MemberVO m = getMemberById(memberVO.getId());
		if(m == null)
			return 0;
		
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		
		return 1;
	}
	
	//D
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		//TODO: process POST request
		try {
			service.getList().remove(getMemberById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
		return 1;
	}
	
}
