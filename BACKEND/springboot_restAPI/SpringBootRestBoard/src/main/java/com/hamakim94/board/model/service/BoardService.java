package com.hamakim94.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.hamakim94.board.model.dto.Board;

public interface BoardService {
	// 글 쓰기
	void writeBoard(Board board); // dao는 insert
	// 글 수정
	void modifyBoard(Board board);
	// 글 삭제
	void deleteBoard(int id);
	// 조회수 증가
	void updateCnt(int id);
	// 글 얻어오기 - 수정할 떄
	Board getBoardById(int id);
	// 글 읽기 - 보여줄 때
	Board readBoard(int id);
	// 모든 게시물 조회
	List<Board> getBoardList(HashMap<String, String> params);
}
