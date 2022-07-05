package com.board2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.board2.domain.BoardDTO;
import com.board2.mapper.BoardMapper;

@SpringBootTest
class Board2ApplicationTests {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired SqlSessionFactory sessionFactory;
	@Autowired BoardMapper mapper;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testApplicationContext() {
		try {
			System.out.println(context.getBean("sqlSessionFactory"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tstSqlFactory() {
		try {
			System.out.println("sessionFactory toString() : "+ sessionFactory.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tstInsert() {
		BoardDTO params = new BoardDTO();
		params.setTitle("tstTitle");
		params.setContent("content");
		params.setWriter("writer1");
		int result = mapper.insertBoard(params);
		
		System.out.println("insert result : "+ result);
	}

}
