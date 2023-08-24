package com.ssafy.aop;

import org.springframework.stereotype.Component;

// 공통관심사항 코드들을 정의

public class MyAspect {
	public void before() {
		System.out.println("입실 체크를 합니다");
	}

	public void after_rt() {
		System.out.println("퇴실 체크를 합니다");
	}

	public void after_th() {
		System.out.println("임의 퇴실!!!");
	}

	public void after() {
		System.out.println("달달한 저녁시간을 보냅니다.");
	}
}
