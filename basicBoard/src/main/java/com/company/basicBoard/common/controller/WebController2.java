package com.company.basicBoard.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController2 {



	/**
	 * 게시판 페이지 호출
	 */
	@GetMapping("/")
	public String board() {
		return "123";
	}
}