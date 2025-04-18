package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.dao.MemberDao;
import com.rubypaper.domain.MemberVO;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class MemberberDaoTest {

	@Autowired
	MemberDao memberDao;

	@Order(4)
	@Test
	public void selectTest() {
		Map<String, Object> map = memberDao.getAllMembers();
		List<MemberVO> lists = (List<MemberVO>) map.get("lists");
		for (MemberVO m : lists) {
			System.out.println(m);
		}

	}

	@Order(1)
	@Test
	public void insertTest() {
		Map<String, Object> map = memberDao.addMember(MemberVO.builder()
				.name("홍길동")
				.pass("1234")
				.build());
		System.out.println("insert");
		assertEquals(true, map.get("success"));
	}

	@Order(2)
	@Test
	public void updateTest() {
		Map<String, Object> map = memberDao.updateMember(MemberVO.builder()
				.id(1)
				.name("홍길동")
				.pass("1234")
				.build());
		System.out.println("update");
		assertEquals(true, map.get("success"));
	}
	
	@Order(3)
	@Test
	public void deleteTest() {
		Map<String, Object> map = memberDao.deleteMember(1);

		System.out.println("delete");
		assertEquals(true, map.get("success"));
	}
}
