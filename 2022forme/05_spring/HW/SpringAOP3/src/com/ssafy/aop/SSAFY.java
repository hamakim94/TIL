package com.ssafy.aop;

import org.springframework.stereotype.Component;


public class SSAFY implements Person {

	@Override
	public void doSometing() throws CoronaException {
		System.out.println("소와 같이 공부를 한다.");
	
	}
	
}
