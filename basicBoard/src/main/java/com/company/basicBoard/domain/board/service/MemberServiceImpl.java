package com.company.basicBoard.domain.board.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.company.basicBoard.domain.board.mapper.MemberMapper;
import com.company.basicBoard.domain.board.model.MemberVO;
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper membermapper;

	@Override
	public void memberJoin(MemberVO member) {	
		
		membermapper.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId){
		
		return membermapper.idCheck(memberId);
	}
}
