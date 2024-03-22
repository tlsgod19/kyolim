package com.company.basicBoard.domain.board.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.company.basicBoard.domain.board.model.MemberVO;

@Mapper
public interface MemberMapper {
	void memberJoin(MemberVO member);
	public int idCheck(String memberId);
}
