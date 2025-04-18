package edu.pnu.controller;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberController {
	
	
	private final MemberService service;
	
	@Autowired
	public MemberController(MemberService service) {
		
		this.service = service;
	}
	
	//R
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return service.getAllMembers();
	}
	
	//R
	@GetMapping("/member")
	public MemberVO getMember(Integer id){
		return service.getMember(id);
	}
	
	@GetMapping("/member/{name}")
	public ResponseEntity<?> getMemberUse(Integer id){

		
		return ResponseEntity.ok(service.getMember(id)); 
	}
	
	//C
	@PostMapping("/member")
	public int addMember(MemberVO memberVO){
		//id가 있으면
		
		
		//완료되면 그대로 반환
		return service.addMember(memberVO);
	} 
	
	//U
	@PutMapping("/member")
	public int updateMember(MemberVO memberVO) {
		
		
		return service.updateMember(memberVO);
	}
	
	//D
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		
		return service.removeMember(id);
	}
		
}
