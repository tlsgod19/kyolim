/*
 * package com.company.basicBoard.domain.board.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.company.basicBoard.domain.board.model.MemberVO; import
 * com.company.basicBoard.domain.board.service.UserService;
 * 
 * @Controller
 * 
 * 
 * public class LoginController {
 * 
 * @Autowired UserService userservice;
 * 
 * @GetMapping(value= "/login") public String loginController() {
 * 
 * return "views/board/login"; }
 * 
 * @PostMapping(value = "/login") public String login(@RequestParam("username")
 * String username,
 * 
 * @RequestParam("password") String password) { MemberVO loginSuccess =
 * userservice.user(username, password); if(true) { return "redirect:/list";
 * }else { return null; }
 * 
 * 
 * } }
 */