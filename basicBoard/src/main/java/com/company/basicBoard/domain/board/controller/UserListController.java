package com.company.basicBoard.domain.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserListController {
	@GetMapping(value="/userlist")
	public String userlistController()	{
		
		return "views/board/userList";
	}
}
