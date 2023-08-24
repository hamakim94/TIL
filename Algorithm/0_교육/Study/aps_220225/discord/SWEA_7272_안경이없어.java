package discord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7272_안경이없어 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			String[] now = br.readLine().split(" ");
			
			// 021 로 이루어진 문자열이 같다면 SAME. 아니면 DIFF
			if (changeToNum(now[0]).equals(changeToNum(now[1]))) {
				System.out.println("#" + tc + " " + "SAME");
			} else {
				System.out.println("#" + tc + " " + "DIFF");
			}

		} // end testCase
	}// end main

	
	// 구멍 2개 : 2, 구멍 1개 : 1, 나머지 0을 문자열로 더해줘서 반환하는 함수
	public static String changeToNum(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);

			if (now == 'B') {
				sb.append(2);
			} else if (now == 'A' || now == 'D' || now == 'O' || now == 'P' || now == 'Q' || now == 'R') {
				sb.append(1);
			} else {
				sb.append(0);
			}

		}
		return sb.toString();
	}
}
