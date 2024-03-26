package com.company.basicBoard.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	/**
	 * 기본 경로 : 게시판 페이지 호출
	 */
	@GetMapping("/test")
	public String home() {
		return "redirect:board";
	}

	/**
	 * 게시판 페이지 호출
	 */
	@GetMapping("/board")
	public String board() {
		return "list"; //  views/board/list
	}
	@GetMapping("/insert")
	public String insert() {
		return "views/board/insert";
	}

}