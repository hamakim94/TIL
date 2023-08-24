package aps_220221;

import java.util.Scanner;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.Select;

public class SWEA_1224_계산기3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 입력
		for (int tc = 1; tc <= 10; tc++) {

			Stack<Character> stackCalc = new Stack<>(); // + 넣을 스택

			int n = sc.nextInt();
			String str = sc.next(); // 후위표기식으로 생성
			String post = "";
			// 내 계획
			for (int i = 0; i < n; i++) {
				char now = str.charAt(i);
				// 1. 일단 숫자면, 그냥 post에 더해주기
				if (now >= '0' && now <= '9') {
					post += (now + "");
				} else {// 2. 기호라면..
					// 2-1. +인 경우
					if (now == '+') {
						// 안에 뭐 들어있으면 문자열에 더해주고 푸쉬푸쉬, (를 만나면 멈춰
						while (!stackCalc.isEmpty() && stackCalc.peek() != '(') {
							post += (stackCalc.pop() + "");
						} // 비어있으면 그냥 푸쉬
						stackCalc.push(now);
						// 2-2. *인 경우
					} else if (now == '*') {
						// stack이 비어있지 않고 peek이 *면 뽑아서 post에 더해
						while (!stackCalc.isEmpty() && stackCalc.peek() == '*') {
							post += (stackCalc.pop() + "");
						} // 아니면 그냥 더해주기
						stackCalc.push(now);
						// 2-3 (인 경우
					} else if (now == '(') {
						// stack에 그냥 더해줘
						stackCalc.push(now);
						// 2-4 )인 경우
					} else { // now == ')'
						// (를 만날 때 까지 스택 비워!
						while (stackCalc.peek() != '(') {
							post += stackCalc.pop();
						} // 마지막에 pop해줘 (스택 비우기
						stackCalc.pop();
					}
				}
			} // end for : 스택이 안 비워질 수 도 있는 상태
			while (!stackCalc.isEmpty()) {
				post += stackCalc.pop();
			}

			Stack<Integer> stackNum = new Stack<>(); // 숫자 넣을 스택
			for (int i = 0; i < post.length(); i++) {
				char now = post.charAt(i);
				// 숫자면 스택에 넣어주고
				if (now >= '0' && now <= '9') {
					stackNum.push(now - '0');
				} else {
					// +면 그냥 2개 pop해서 더해주고 다시 넣어줘
					if (now == '+') {
						int now1 = stackNum.pop();
						int now2 = stackNum.pop();
						stackNum.push(now1 + now2);
					} else {
						// *면 그냥 2개 pop해서 곱해주고 다시 넣어줘
						int now1 = stackNum.pop();
						int now2 = stackNum.pop();
						stackNum.push(now1 * now2);
					}
				}
			} // end for : 변환 완료
			System.out.println("#" + tc + " " + stackNum.get(0));

		}

	}
}
