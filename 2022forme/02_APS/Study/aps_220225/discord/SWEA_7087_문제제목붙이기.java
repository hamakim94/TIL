package discord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7087_문제제목붙이기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {

			int N = Integer.parseInt(br.readLine());

			// 65 ~ 90 을 담을 배열 생성
			char[] countArr = new char[26];
			// 입력값의 첫 글 자 만든 배열에 index로 사용하기 위해 -'A'
			// 배열은 heap에 생성, 초기값 0, A - 0번 인덱스에 되니 1씩 더해준다. 
			for (int i = 0; i < N; i++) {
				countArr[br.readLine().charAt(0) - 'A'] += 1;
			}

			// 갯수를 셀 변수
			int cnt = 0;
			// 첫 번째 문자의 개수를 담은 배열을 돌면서
			for (int i = 0; i < 26; i++) {
				// 개수가 있다면 cnt1에 1 더해주고
				if (countArr[i] > 0) {
					cnt++;
					// 없자마자 끝내버려
				} else {
					break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		} // end testCase

	}
}
