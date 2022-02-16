package aps_220216;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {

		// 인풋 받기 및 미리 변수 지정
		Scanner sc = new Scanner(System.in);
		String str;
		Stack<Character> stack;

		for (int tc = 1; tc <= 10; tc++) {
			// 사이즈 받기
			int size = sc.nextInt();
			// 스택, 스트링 받기
			stack = new Stack<>();
			str = sc.next();
			// 현재 원소와, pop된걸 보자
			char now;
			char last;
			for (int i = 0; i < size; i++) {
				// 현재 char
				now = str.charAt(i);
				// 괄호가 열리면 스택에 푸쉬!
				if (now == '(' || now == '<' || now == '[' || now == '{') {
					stack.push(now);
				} else {
					// 일단 마지막 원소 pop해서
					last = stack.pop();
					// 다르면 그냥 끝내버려!
					if (last == '(' & now != ')') {
						break;
					} else if (last == '<' & now != '>') {
						break;
					} else if (last == '[' & now != ']') {
						break;
					} else if (last == '{' & now != '}') {
						break;
					}

				}
			} // end for : 참거짓 판별 완료
			if (stack.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}

	}
}
