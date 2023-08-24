package com.hamakim94.board.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamakim94.board.model.dao.BoardDao;
import com.hamakim94.board.model.dto.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);

	}

	@Override
	public void modifyBoard(Board board) {
		Board originBoard = boardDao.selectOne(board.getId());
		originBoard.setTitle(board.getTitle());
		originBoard.setContent(board.getContent());
		boardDao.updateBoard(originBoard);

	}

	@Override
	public void deleteBoard(int id) {
		Board board = boardDao.selectOne(id);
		// 경로에 있는 애도 지우고 db지우기
		if (board.getFileUri() != null) {
			new File(board.getFileUri()).delete();
		}
		boardDao.deleteBoard(id);

	}

	@Override
	public void updateCnt(int id) {
		// TODO Auto-generated method stub
		Board board = boardDao.selectOne(id);
		board.setViewCnt(board.getViewCnt() + 1);
		boardDao.updateBoard(board);

	}

	@Override
	public Board getBoardById(int id) {
		// TODO Auto-generated method stub
		return boardDao.selectOne(id);
	}

	@Override
	public Board readBoard(int id) {
		this.updateCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> getBoardList(HashMap<String, String> params) {
		// TODO Auto-generated method stub
		return boardDao.selectList(params);
	}

}
