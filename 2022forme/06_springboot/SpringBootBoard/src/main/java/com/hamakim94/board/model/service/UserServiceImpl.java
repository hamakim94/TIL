package com.hamakim94.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamakim94.board.exception.PWIncorreectException;
import com.hamakim94.board.exception.UserNotFoundException;
import com.hamakim94.board.model.dao.BoardDao;
import com.hamakim94.board.model.dao.UserDao;
import com.hamakim94.board.model.dto.Board;
import com.hamakim94.board.model.dto.User;
import com.hamakim94.board.util.SHA256;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BoardDao boardDao;

	@Transactional
	@Override
	public void join(User user, String msg) throws Exception {
		user.setPw(new SHA256().getHash(user.getPw()));
		Board b = new Board();
		b.setTitle(user.getUsername() + "가입 인사입니다");
		b.setContent(msg);
		b.setWriter(user.getUsername());
		// 여기서 insert하다가 삑사리 ? 롤백 ? 트랜잭션!
		boardDao.insertBoard(b);
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String pw) throws Exception {
		// id로 select해와서
		User user = userDao.selectById(id);

		if (user == null)
			throw new UserNotFoundException();
		// 그 user가 pw 맞으면 ㅇㅋ
		if (!user.getPw().equals(new SHA256().getHash(pw)))
			throw new PWIncorreectException();
		else
			return user;

	}

}
