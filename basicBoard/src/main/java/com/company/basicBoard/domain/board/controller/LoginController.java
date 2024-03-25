
package com.company.basicBoard.domain.board.controller;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.basicBoard.domain.board.model.MemberVO;
import com.company.basicBoard.domain.board.service.MemberService;

import jakarta.servlet.http.HttpServletRequest; 

@Controller


public class LoginController {
	
	@Autowired
	MemberService memberservice;
	@GetMapping(value= "/login")
	public String loginController() {

		return "views/board/login"; 
		}
	
	public MemberVO memberLogin(MemberVO member){
		memberservice.memberLogin(member);
		
		return null;
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr){
		
		System.out.println("login 메서드 진입");
		System.out.println("전달된 데이터 : " + member);
		
		return null;
	}
	
	} 
