package BOJ_220324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	// 입력 받을 값
	static int input = 0;
	static String now;

	public static void main(String[] args) throws IOException {

		// 입력 값을 바로 인덱스로 쓸래!
		int[] set = new int[21];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 개수
		int n = Integer.parseInt(br.readLine());
		
		// 0이면 있고, 1이면 없어!
		for (int i = 0; i < n; i++) {
			// case 시작
			st = new StringTokenizer(br.readLine());
			now = st.nextToken();
			switch (now) {
			// 있으면 무시, 없으면 추가
			case "add":
				// 입력 받는 숫자.
				input = Integer.parseInt(st.nextToken());
				if (set[input] == 0)
					set[input] = 1;
				// 있는 경우 무시
				break;

			case "remove":
				input = Integer.parseInt(st.nextToken());
				// 있으면
				if (set[input] == 1)
					// 빼줘
					set[input] = 0;
				// 없는 경우 무시
				break;

			case "check":
				input = Integer.parseInt(st.nextToken());
				// 있으면 1
				if (set[input] == 1)
					sb.append(1).append("\n");
				// 아님 0
				else
					sb.append(0).append("\n");
				break;

			case "toggle":
				// 바꿔주기
				input = Integer.parseInt(st.nextToken());
				set[input] = (set[input] + 1) % 2;
				
				break;
				
			case "all":
				for (int k = 1; k <= 20; k++) {
					set[k] = 1;
				}
				break;
				
			case "empty":
				for (int k = 1; k <= 20; k++) {
					set[k] = 0;
					
				}
				break;
			}

		} // end for
		System.out.println(sb);

	}
}
