package com.company.basicBoard.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.basicBoard.domain.board.model.BoardVO;
import com.company.basicBoard.domain.board.service.BoardService;
@Controller
public class DetailController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/detailBoards")
	public String getDetailBoard(BoardVO board,@PageableDefault(size = 10) Pageable pageable,org.springframework.ui.Model model) {
		model.addAttribute("data",boardService.getBoardDetail(board));
	    return "views/board/detail";

	}

	@RequestMapping(value = "/updateBoards")
	public String getupdateBoard(BoardVO board,@PageableDefault(size = 10) Pageable pageable,org.springframework.ui.Model model) {
		model.addAttribute("data",boardService.getBoardDetail(board));
	    return "views/board/update";

	}

}
