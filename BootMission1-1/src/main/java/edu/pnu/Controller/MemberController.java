package edu.pnu.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	
	MemberService service;
	
	public MemberController() {
		//리스트 객체 생성
		service = new MemberService();
		
	}
	
	//R
	@GetMapping("/members")
	public List<MemberVO> getAllMember(){
		return service.getList();
	}
	
	//R
	@GetMapping("/member")
	public ResponseEntity<?> getElementById(Integer id) {
		
		for (MemberVO n : service.getList()) {
			if(n.getId() == id)
			{
				return ResponseEntity.ok(n);
			}
		}

		return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//U
	@PostMapping("/member")
	public int updateElementById(Integer id,String name, String pass) {
		
		//id에 해당하는 id가 있으면
		
		for (MemberVO n : service.getList()) {
			if(n.getId() == id)
			{
				n.setName(name);
				n.setPass(pass);
				return 1;
			}
		}
		
		return 0;
	}
	
	//C
	@PostMapping("/memeber")
	public int setElementById(Integer id,String name, String pass) {
		
		
		//id에 해당하는 id가 있으면
		for (MemberVO n : service.getList()) {
			if(n.getId() == id)
			{
				return 0;
			}
		}
		
		service.getList().add(MemberVO
				.builder()
				.id(id)
				.name(name)
				.pass(pass)
				.regidate(new Date())
				.build());
		
		
		return 1;
	}
	
	@DeleteMapping("/member")
	public int deleteElementById(Integer id) {
		
		
		//id에 해당하는 id가 있으면
		for (int i = 0; i < service.getList().size();i++) {
			if(service.getList().get(i).getId() == id)
			{
				service.getList().remove(i);
				
				return 1;
			}
		}
		
		return 0;
	}
	
}
