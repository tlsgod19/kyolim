package com.company.basicBoard.domain.board.service;
import com.company.basicBoard.domain.board.model.MemberVO;

public interface MemberService {
	
	public void memberJoin(MemberVO member);

	public int idCheck(String memberId); 
	
};
