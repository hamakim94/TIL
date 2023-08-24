package com.ssafy.hw10.step2;

import java.io.Serializable;

public class User implements Serializable {
	//id가 스트링 : 아이디니까!
	private String id;
	// 비번이잖아!
	private String password;
	//이름
	private String name;
	//이메일
	private String email;
	//나이
	private int age;
	
	// 기본생성자 & 매개변수 넣은 생성자
	User(){
	}
	User(String id, String password, String name, String email, int age){
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	// source를 활용한 자동 게러엔세러
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// 보기 편하게 하나씩 출력해주세요~
	@Override
	public String toString() {
		return "User id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age ;
	}
	
	
}
