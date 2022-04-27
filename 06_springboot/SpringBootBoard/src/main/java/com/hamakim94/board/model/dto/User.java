package com.hamakim94.board.model.dto;

public class User {
	
	private int seq;
	private String id;
	private String pw;
	private String username;
	
	public User() {
		
	}
	
	
	
	public User(String id, String pw, String username) {
		this.id = id;
		this.pw = pw;
		this.username = username;
	}



	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", pw=" + pw + ", username=" + username + "]";
	}
	

}
