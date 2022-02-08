package com.ssafy.hw10.step2;

public class NameNotFoundException extends RuntimeException {
	private String name = "에 해당하는 변수는 없습니다.";

	public NameNotFoundException(String name) {
		System.out.println(name + this.name );
	}
	public String getName() {
		return this.name;
	}

}
