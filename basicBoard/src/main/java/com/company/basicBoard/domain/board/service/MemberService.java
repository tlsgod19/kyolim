package com.company.basicBoard.domain.board.service;

import java.util.Map;

import org.springframework.data.domain.Page;


import com.company.basicBoard.domain.board.model.MemberVO;

public interface MemberService {
	
	public void memberJoin(MemberVO member);
};
