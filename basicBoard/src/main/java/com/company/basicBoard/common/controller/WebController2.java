package com.company.basicBoard.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController2 {



	/**
	 * 게시판 페이지 호출
	 */
	@GetMapping("/board2")
	public String board() {
		return "views/board/list2";
	}
}