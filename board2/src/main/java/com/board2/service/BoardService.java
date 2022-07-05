package com.board2.service;

import java.util.List;

import com.board2.domain.BoardDTO;

public interface BoardService {
	public int insertBoard(BoardDTO params);
	public BoardDTO selectBoardDetail(Long idx);
	public int updateBoard(BoardDTO params);
	public int deleteBoard(Long idx);
	public List<BoardDTO> selectBoardList();
	public int selectBoardTotalCount();
	public boolean cntPlus(Long idx);
}
