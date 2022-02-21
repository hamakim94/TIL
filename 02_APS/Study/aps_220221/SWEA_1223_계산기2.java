package aps_220221;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 입력
		for (int tc = 1; tc <= 10; tc++) {

			Stack<Character> stackCalc = new Stack<>(); // + 넣을 스택

			int n = sc.nextInt();
			String str = sc.next(); // 후위표기식으로 생성
			String post = "";
			for (int i = 0; i < n; i++) {
				char now = str.charAt(i);
				// 숫자면 그냥 post라는 문자에 더해줘
				if (now >= '0' && now <= '9') {
					post += (now + "");
				} else {

				}
				if (now == '*') {// 비어있지 않고, 탑이 *라면, *가 아닐 떄 까지 뽑고
					while (!stackCalc.isEmpty() && stackCalc.peek() == '*') {
						post += (stackCalc.pop() + "");
					}
					stackCalc.add(now); // 나중에 더해줘 : 우선순위가 +보단 높으므로, +를 만나기 전 까지 다 뺴준다
				}

				else if (now == '+') { // 덧셈인 경우
					// 일단 비어있을때까지 다 뽑아(우선순위가 낮기 떄문)
					while (!stackCalc.isEmpty()) {
						post += (stackCalc.pop() + "");
					}
					stackCalc.add(now);

				}
			} // end for : 후위표기식
			while (!stackCalc.isEmpty()) {
				post += stackCalc.pop();
			}
			// System.out.println(post);

			Stack<Integer> stackNum = new Stack<>(); // 숫자 넣을 스택
			for (int i = 0; i < post.length(); i++) {
				char now = post.charAt(i);

				if (now >= '0' && now <= '9') {
					stackNum.push(now - '0');
				} else {
					if (now == '+') {
						int now1 = stackNum.pop();
						int now2 = stackNum.pop();
						stackNum.push(now1 + now2);
					} else {
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
