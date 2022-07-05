package com.board2.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
			System.out.println(dto.getIdx() +"번 조회수 : "+ dto.getViewCnt());
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
		
		return "board/detail";
	}
	
	@GetMapping("board/cntPlus/{id}")
	public void cntPlus(@PathVariable("id") Long id) {
		boardService.cntPlus(id);
	}
	
	@PostMapping("board/write")
	public String writeContent(ModelMap model ) {
		String chkType = "insert";
		model.put("insert", chkType);
		
		return "board/write";
	}
	
	@GetMapping("board/updateContent")
	public String updateContent(ModelMap model, @RequestParam Map<String, Object> param) {
		String chkType = "update";
		model.put("chkType", chkType);
		
		return "board/write";
	}
	
	@PostMapping("board/deleteContent")
	public String deleteContent(ModelMap model, long id) {
		int result = boardService.deleteBoard(id);
		if(result > 0) {
			return "board/boardList";
		}
		return "redirect:board/detail";
	}
}