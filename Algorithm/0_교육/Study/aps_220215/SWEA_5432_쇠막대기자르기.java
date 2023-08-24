package aps_220215;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();// testCase 입력
		String str; // 입력받을 String 문자열 정의
		ArrayList<Character> arr; // 문자 하나씩 넣을 ArrayList
		char now; // 현재 값
		char next; // 다음 인덱스 값
		int cnt; // 개수를 구하기

		for (int test = 1; test <= tc; test++) {
			arr = new ArrayList<>();
			cnt = 0;
			// 입력을 받았음
			str = sc.next();
			for (int i = 0; i < str.length() - 1; i++) {
				// 2개씩 돌면서
				now = str.charAt(i);
				next = str.charAt(i + 1);
				// "((" 이면, arraylist에 add해준다.
				if (now == '(' && next == '(') {
					arr.add(now);
					// "()" 이면, 레이저, 현재 배열에 add된 '('의 길이를 더해준다
				} else if (now == '(' && next == ')') {
					// 맨 마지막꺼 하나 제거
					cnt += arr.size();
					// "))"이면, 막대기 하나 완료, 막대기 시작점들의 길이인 배열에 -1 해주고, 막대기 하나 짤렸으므로 cnt + 1;
				} else if (now == ')' && next == ')') {
					arr.remove(arr.size() - 1);
					cnt += 1;//
				} // end if-elseif-elseif : 끝

			} // end for : cnt 구함!
			System.out.println("#" + test + " " + cnt);
		}
		sc.close();

	}
}
