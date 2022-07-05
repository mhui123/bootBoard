package com.board2.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board2.domain.BoardDTO;
import com.board2.service.BoardService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class BoardController {
	@Autowired BoardService boardService;
	
	@GetMapping("/")
	public String boardMainPage(ModelMap model) {
		List<BoardDTO> list = boardService.selectBoardList();
		for(BoardDTO dto : list) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			dto.setInsertTime(dto.getInsertTime().formatted(formatter));
		}
		model.put("boardList", list);
		
		return "board/boardList";
	}
	
	@GetMapping("/board/detail/{id}")
	public String openDetail(@PathVariable("id") Long id, ModelMap model) {
		log.debug("clicked id: {}", id);
		System.out.println("sysou clicked id : "+ id);
		
		BoardDTO dto = boardService.selectBoardDetail(id);
		model.put("dto", dto);
		model.put("gubun", "select");
		
		return "board/detail";
	}
	
	@GetMapping("board/cntPlus/{id}")
	public void cntPlus(@PathVariable("id") Long id) {
		boardService.cntPlus(id);
	}
	
	@GetMapping("board/writePage")
	public String writeContent(ModelMap model) {
		return "board/write";
	}
	
	@PostMapping("board/writeContent")
	@ResponseBody
	public int insertContent(@RequestParam Map<String, Object> param) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle((String)param.get("title"));
		dto.setContent((String)param.get("content"));
		dto.setWriter((String)param.get("writer"));
		
		return boardService.insertBoard(dto);
	}
	
	@PutMapping("board/updatePage")
	@ResponseBody
	public int updateContent(ModelMap model, @RequestParam Map<String, Object> param) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle((String)param.get("title"));
		dto.setContent((String)param.get("content"));
		dto.setWriter((String)param.get("writer"));
		dto.setIdx(Long.parseLong((String)param.get("idx")));
		
		return boardService.updateBoard(dto);
	}
	
	@DeleteMapping("board/deletePage")
	@ResponseBody
	public int deleteContent(ModelMap model, @RequestParam Map<String, Object> param) {
		long idx = Long.parseLong((String)param.get("idx"));
		int result = boardService.deleteBoard(idx);
		
		return result;
	}
}