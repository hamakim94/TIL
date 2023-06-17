package BOJ_220418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 이게 그냥 5번째 전꺼 더하면 되네요
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;

		for (int i = 7; i < 101; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int input = Integer.parseInt(br.readLine());
			if (t == 0) {
				sb.append(dp[input]);
			} else {
				sb.append("\n").append(dp[input]);
			}
		}
		System.out.println(sb);
	}
}
