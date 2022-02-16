package aps_220216;

import java.util.Stack;

public class Stack_02_API {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// Vector의 add를 부름
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4); // return값이 boolean, 정상적으로 추가는 됨
		
		// Stack push 메서드를 부름,
		System.out.println(stack.push(5));
		
		// Stack의 모든것을 꺼낼래
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
