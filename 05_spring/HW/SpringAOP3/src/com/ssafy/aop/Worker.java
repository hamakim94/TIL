package com.ssafy.aop;

import org.springframework.stereotype.Component;


public class Worker implements Person {

	@Override
	public void doSometing() throws CoronaException {
		// TODO Auto-generated method stub
		System.out.println("소와 같이 일을 한다.");
	}
	

}
