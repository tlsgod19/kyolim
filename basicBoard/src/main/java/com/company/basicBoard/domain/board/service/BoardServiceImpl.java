package com.company.basicBoard.domain.board.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.basicBoard.common.data.RequestList;
import com.company.basicBoard.domain.board.mapper.BoardMapper;
import com.company.basicBoard.domain.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public Page<Map<String, Object>> getListBoard(BoardVO board, Pageable pageable) {

		// 빌더 패턴으로 data, pageable 파라미터에 데이터 주입
		RequestList<?> requestList = RequestList.builder()
				.data(board)
				.pageable(pageable)
				.build();

		List<Map<String, Object>> content = boardMapper.getListBoard(requestList);
		int total = boardMapper.getListBoardCount(board);

		return new PageImpl<>(content, pageable, total);
	}
	@Override
	public void getListInsert(BoardVO board, Pageable pageable){

			boardMapper.InsertBoard(board);



	}
	@Override
	public BoardVO getBoardDetail(BoardVO board) {

		return boardMapper.DetailBoard(board);
	}
	@Override
	public void getListUpdate(BoardVO board, Pageable pageable) {
		// TODO Auto-generated method stub
		boardMapper.UpdateBoard(board);
	}


	
	@Override 
	public void signup(String username, String email, String password){
		 boardMapper.SignUp(username, email, password); 
	}
	 
}