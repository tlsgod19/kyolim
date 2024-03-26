package com.company.basicBoard.domain.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.basicBoard.domain.board.model.BoardVO;
import com.company.basicBoard.domain.board.service.BoardService;


@RestController
@RequestMapping(value = "/boards")
public class BoardController {

	@Autowired
	BoardService boardService;

	/*
	 * @GetMapping("") public ResponseEntity<?> getListBoard(BoardVO
	 * board, @PageableDefault(size = 10) Pageable pageable) { return
	 * ResponseEntity.ok(boardService.getListBoard(board, pageable)); }
	 */
    
    public String boardList(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
                
        List<BoardVO> list = boardService.selectBoardList(boardVO);
        
        model.addAttribute("list", list);
        
        return "list";
    }
    
	
}