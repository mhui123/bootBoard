package com.board2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board2.dao.BoardDao;
import com.board2.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired private BoardDao dao;
	
	@Override
	public int insertBoard(BoardDTO params) {
		return dao.insertBoard(params);
	}

	@Override
	public BoardDTO selectBoardDetail(Long idx) {
		return dao.selectBoardDetail(idx);
	}

	@Override
	public int updateBoard(BoardDTO params) {
		return dao.updateBoard(params);
	}

	@Override
	public int deleteBoard(Long idx) {
		return dao.deleteBoard(idx);
	}

	@Override
	public List<BoardDTO> selectBoardList() {
		return dao.selectBoardList();
	}

	@Override
	public int selectBoardTotalCount() {
		return dao.selectBoardTotalCount();
	}

	@Override
	public boolean cntPlus(Long idx) {
		return dao.cntPlus(idx);
	}
	
}
