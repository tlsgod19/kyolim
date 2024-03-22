package com.company.basicBoard.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.basicBoard.domain.board.model.BoardVO;
import com.company.basicBoard.domain.board.service.BoardService;

@RestController
@RequestMapping(value = "/insertBoards")
public class InsertController {

	@Autowired
	BoardService boardService;

	@GetMapping("")
	public void getListBoard(BoardVO board,@PageableDefault(size = 10) Pageable pageable) {
		boardService.getListInsert(board, pageable);
	}
}