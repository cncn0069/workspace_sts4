package com.rubypaper.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;


@RestController
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BVoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		return BoardVO.builder()
				.seq(1)
				.title("테스트 제목...")
				.writer("테스터")
				.content("테스트 내용입니다.")
				.createDate(new Date())
				.cnt(0)
				.build();
		
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			BoardVO board = BoardVO.builder()
						.seq(1)
						.title("테스트 제목...")
						.writer("테스터")
						.content("테스트 내용입니다.")
						.createDate(new Date())
						.cnt(0)
						.build();

			boardList.add(board);
		}
		return boardList;
	}
}


