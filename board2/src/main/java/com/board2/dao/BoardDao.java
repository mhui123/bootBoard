package com.board2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board2.domain.BoardDTO;
import com.board2.mapper.BoardMapper;

@Repository
public class BoardDao implements BoardMapper{
	@Autowired BoardMapper mapper;
	@Override
	public int insertBoard(BoardDTO params) {
		return mapper.insertBoard(params);
	}

	@Override
	public BoardDTO selectBoardDetail(Long idx) {
		return mapper.selectBoardDetail(idx);
	}

	@Override
	public int updateBoard(BoardDTO params) {
		return mapper.updateBoard(params);
	}

	@Override
	public int deleteBoard(Long idx) {
		return mapper.deleteBoard(idx);
	}

	@Override
	public List<BoardDTO> selectBoardList() {
		return mapper.selectBoardList();
	}

	@Override
	public int selectBoardTotalCount() {
		return mapper.selectBoardTotalCount();
	}

	@Override
	public boolean cntPlus(Long idx) {
		return mapper.cntPlus(idx);
	}
	
}
