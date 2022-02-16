package aps_220216;

public class Stack_04_FunctionCall {
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		func1();
		System.out.println("메인함수 종료");
	}
	
	public static void func1() {
		System.out.println("함수1 실행");
		func2();
		System.out.println("함수1 종료");
	}
	
	public static void func2() {
		System.out.println("함수2 실행");
		//작업
		System.out.println("함수2 종료");
	}
}
