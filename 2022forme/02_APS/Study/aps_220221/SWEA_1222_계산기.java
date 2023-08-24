package aps_220221;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222_계산기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 입력
		for (int tc = 1; tc <= 10; tc++) {

			Stack<Integer> stackNum = new Stack<>(); // 숫자 넣을 스택
			Stack<Character> stackPlus = new Stack<>(); // 연산자 넣을 스택

			int n = sc.nextInt();
			String str = sc.next();

			for (int i = 0; i < n; i++) {
				char now = str.charAt(i);
				if (now >= '0' && now <= '9') { // 0~9 사이 숫자면 stackNum에
					stackNum.add(now - '0');
				} else {
					stackPlus.add(now); // 아니면 연산자스택에

				}
			} // end for : stack쌓기 완료

			// 연산자 스택이 비어있을 떄 까지
			while (stackPlus.size() > 0) {

				int a = stackNum.pop();
				int b = stackNum.pop(); // 두개 더하고
				stackNum.add(a + b); // 더한 결과를 넘버스택에 다시 넣어주고
				stackPlus.pop(); // 연산자 하나를 뺴준다
			} // 마지막에 있는 숫자가 다 더한 결과!
			System.out.println("#" + tc + " " + stackNum.get(0));
		}
	}
}
