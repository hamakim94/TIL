package com.hamakim94.board.model.service;

import com.hamakim94.board.model.dto.User;

public interface UserService {
	// 회원가입 할 때 인삿말까지 적어서 게시글로 등록하도록
	void join(User user, String msg) throws Exception;
	// 아이디, 비밀번호챠랍!
	User login(String id, String pw) throws Exception;

	
}
