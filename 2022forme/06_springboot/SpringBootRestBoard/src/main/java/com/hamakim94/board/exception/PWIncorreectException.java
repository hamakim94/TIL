package com.hamakim94.board.exception;

public class PWIncorreectException extends Exception{
	public PWIncorreectException() {
		super("비밀번호를 찾을 수 없습니다");
	}

}
