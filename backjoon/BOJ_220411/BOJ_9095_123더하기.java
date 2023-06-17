package BOJ_220411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_9095_123더하기 {
	// 일단 단순한 생각
	// 김재귀
	// 그냥 for문 ,1,2,3 돌면서
	// 누적해서 더해가서
	// 입력 숫자 나오면 +1;
	// 커지면 break;
	static int cnt; // 전체 개수 출력
	static int ans; // 여기가 정답이란다!

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			cnt = 0;// 초기화
			ans = Integer.parseInt(br.readLine());
			go(0);
			if(i == 0)
				sb.append(cnt);
			else 
				sb.append("\n").append(cnt);

		} // end testCase
		System.out.println(sb);

	}

	private static void go(int sum) {
		// base case
		if (sum > ans)
			return;
		if (sum == ans) {
			cnt++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			go(sum + i);
		}

	}
}
