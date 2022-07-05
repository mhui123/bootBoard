package com.board2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board2.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	public int insertBoard(BoardDTO params);
	public BoardDTO selectBoardDetail(Long idx);
	public int updateBoard(BoardDTO params);
	public int deleteBoard(Long idx);
	public List<BoardDTO> selectBoardList();
	public int selectBoardTotalCount();
	public boolean cntPlus(Long idx);
}
