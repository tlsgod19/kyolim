package com.company.basicBoard.domain.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.basicBoard.common.data.RequestList;
import com.company.basicBoard.domain.board.model.BoardVO;
@Mapper
public interface BoardMapper {

//	List<Map<String, Object>> getListBoard(RequestList<?> requestList);
	public List<BoardVO> selectBoardList(BoardVO board);
	
	int getListBoardCount(BoardVO board);

	void InsertBoard(BoardVO board);

	BoardVO DetailBoard(BoardVO board);

	void UpdateBoard(BoardVO board);

	void SignUp(String username, String email, String password);
}