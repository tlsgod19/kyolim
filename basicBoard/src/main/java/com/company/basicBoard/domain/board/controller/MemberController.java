package com.company.basicBoard.domain.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.basicBoard.domain.board.model.MemberVO;
import com.company.basicBoard.domain.board.service.BoardService;
import com.company.basicBoard.domain.board.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberservice;
    @GetMapping("/memberJoin")
    public String showSignupForm() {
        return "views/board/memberJoin"; // 회원가입 폼을 나타내는 HTML 파일의 이름 (signup.html)
    }

    @PostMapping("/memberJoin")
  
    public String memberJoin(MemberVO member) {
        // 여기에 회원가입 처리 로직을 구현합니다.
        // 예를 들어, 서비스를 사용하여 회원을 생성하고 데이터베이스에 저장할 수 있습니다.
    	memberservice.memberJoin(member);

        // 회원가입 성공 시 로그인 페이지로 리다이렉트
        return "redirect:/login"; // 로그인 페이지의 URL
    }
    @ResponseBody
    @PostMapping("/memberIdChk")
    public String memberIdchkPOST(String memberId) {
    	int result = memberservice.idCheck(memberId);
    	if (result != 0) {
    		return "fail";
    		
    	}else {
    		return "success";
    	}
    }
}
