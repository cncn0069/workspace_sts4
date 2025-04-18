package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {

	private List<MemberVO> list;

	public MemberService() {
		// TODO Auto-generated constructor stub

		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new MemberVO(i, "123" + i, "test" + i, new Date()));
		}

	}

	public List<MemberVO> getAllMembers() {
		return list;
	}

	public MemberVO getMember(Integer id) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i);
			}
		}

		return null;
	}

	public MemberVO addMember(MemberVO memberVO) {

		if(getMember(memberVO.getId()) != null) {
			System.out.println("이미 존재합니다.");
			return null;
		}
		memberVO.setRegidate(new Date());
		addMember(memberVO);
		
		list.add(memberVO);
		
		return memberVO;
	}
	
	public int updateMember(MemberVO memberVO) {

		if(getMember(memberVO.getId()) == null) {
			System.out.println("존재하지 않습니다.");
			return 0;
		}
		getMember(memberVO.getId()).setName(memberVO.getName());
		getMember(memberVO.getId()).setPass(memberVO.getPass());
		
		return 1;
	}
	
	public int removeMember(Integer id) {
		
		if(getMember(id) == null) {
			System.out.println("존재하지 않습니다.");
			return 0;
		}
		
		//삭제
		list.remove((int)id);
		
		return 1;
	}

}
