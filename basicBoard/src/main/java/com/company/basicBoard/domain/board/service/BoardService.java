package com.company.basicBoard.domain.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.basicBoard.domain.board.model.BoardVO;

public interface BoardService {

	public Page<Map<String, Object>> getListBoard(BoardVO board, Pageable pageable);

	public void  getListInsert(BoardVO board, Pageable pageable);

	public BoardVO getBoardDetail(BoardVO board);


	public void getListUpdate(BoardVO board, Pageable pageable);
	public  void signup(String username, String email, String password);
	



}