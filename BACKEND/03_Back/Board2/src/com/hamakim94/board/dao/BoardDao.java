package com.hamakim94.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.hamakim94.board.dto.Board;

// DataAccessObject
public class BoardDao {
	private List<Board> list = new ArrayList<>();
	private int no = 0;
	
	
	private static  BoardDao instance;
	// 싱글턴 만들자
	private BoardDao() {
		insertBoard(new Board("이 글을 읽지 마시오", "악마", "이 글은 영국에서..."));
		insertBoard(new Board("곧 쉬는시간", "천사", "쉬자구요"));
	}
	// 쓸 때만 만들어
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	// 전체 보드 가져오기
	public List<Board> selectBoard(){
		return list;
	}
	// 파라미터로 넘어온 보드 리스트에 등록하기
	public void insertBoard(Board board) {
		board.setNo(++no);
		list.add(board);
	}
}
