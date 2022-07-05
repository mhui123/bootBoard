package com.board2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board2.domain.BoardDTO;
import com.board2.mapper.BoardMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class MapperTst {
	@Autowired
	private BoardMapper boardMapper;
	
	public void testInsert() {
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 제목");
		params.setContent("1번 내용");
		params.setWriter("테스터");
		
		int result = boardMapper.insertBoard(params);
		System.out.println("result=============> "+result);
	}
	
	@Test
	public void selectTst() {
		BoardDTO board = boardMapper.selectBoardDetail((long) 1);
		try {
			String json = new ObjectMapper().writeValueAsString(board);
			System.out.println(json);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
