package BOJ_220303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열을 넣을 것
		String paragraph = "";

		// .을 만나기 전까지..
		while (true) {

			paragraph = br.readLine(); // br.readline으로 문자열 받기

			// . 만나면 끝!
			if (paragraph.equals(".")) {
				break;
			}

			// 참,거짓 판단
			boolean flag = true;
			// stack 하나 만들기
			Stack<Character> arr = new Stack<>();

			for (int i = 0; i < paragraph.length(); i++) {

				// 괄호 아무것도 없으면 그냥 지나가
				char now = paragraph.charAt(i);
				// 열린 괄호면 무적권 넣고
				if (now == '(' || now == '[') {
					arr.add(now);
					// 닫힌 괄호 만나면 바로 앞에 있는 거랑 비교해서 같으면 skip 다르면 break
				} else if (now == ')') {
					// 비어있으면 이미 틀림. break하기
					if (arr.isEmpty()) {
						flag = false;
						break;
					}
					char poped = arr.pop();
					if (poped != '(') {
						flag = false;
						break;
					}
				} else if (now == ']') {
					// 비어있으면 이미 틀림. break하기
					if (arr.isEmpty()) {
						flag = false;
						break;
					}
					char poped = arr.pop();
					if (poped != '[') {
						flag = false;
						break;
					}
				} // end 조건문
			} // end for : String 돌기 완료
			
			// 다 돌았는데 stack이 있다면..
			if(!arr.isEmpty()) {
				flag = false;
			}

			// 만약 flag가 true면 : 'yes'출력
			// 만약 flag가 false면 : 'no'출력
			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		} // end while : "."을 만나기 전 까지

	}
}
