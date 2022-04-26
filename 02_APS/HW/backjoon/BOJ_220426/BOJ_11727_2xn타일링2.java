package BOJ_220426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2xn타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 왝.. dp[n] = dp[n-1] : 저번 꺼에 오른쪽 하나 붙인거 + 2*dp[n-2]// 2번째 전에 오른쪽에 2개 붙인거
		int idx = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}
		System.out.println(dp[idx]);
	}
}
