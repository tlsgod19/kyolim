
package com.company.basicBoard.domain.board.controller;
 
 
import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.basicBoard.domain.board.model.MemberVO;
import com.company.basicBoard.domain.board.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession; 

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
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr){
		
		
		HttpSession session = request.getSession();
		MemberVO lvo = memberservice.memberLogin(member);
        if(lvo == null) {                                // 일치하지 않는 아이디, 비밀번호 입력 경우
            System.out.println("실패");
            int result = 0;
            rttr.addFlashAttribute("result", result);
            return "redirect:/login";
            
        }
        
        session.setAttribute("member", lvo);             // 일치하는 아이디, 비밀번호 경우 (로그인 성공)
        System.out.println("성공");
        return "redirect:/board";
		
	}
	
	} 
