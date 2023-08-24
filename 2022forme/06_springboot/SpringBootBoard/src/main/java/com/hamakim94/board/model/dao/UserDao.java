package com.hamakim94.board.model.dao;

import com.hamakim94.board.model.dto.User;

public interface UserDao {
	void insertUser(User user) throws Exception;
	User selectById(String id) throws Exception;
}
