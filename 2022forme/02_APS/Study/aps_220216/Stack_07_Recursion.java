package aps_220216;

public class Stack_07_Recursion {
	public static void main(String[] args) {
		// func1();
		func2(5);
	}
	public void func1() {
		// 무한히 호출되는게 맞는데
		// 메모리가 한정적으로 있다보니
		// JVM 스택 메모리에 넘쳐흘러서 종료
		System.out.println("여긴 함수 내부야!");
		func1();
	}
	// 재귀함수 2부분
	// 1. 기본 파트 : 재귀함수를 종료하는 조건
	// 2. 재귀 파트 : 나 자신을 다시 부르는 부분
	public static void func2(int num) {
		if(num == 0) {
			return;
		}
		System.out.println("함수 호출");
		func2(num-1);
		System.out.println(num + "함수 리턴");
	}
	

}
