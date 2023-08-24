package BOJ_220627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
	static int[] arr;
	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		ans = Integer.MIN_VALUE;
		DFS(0, 0, false);
		System.out.println(ans);
	}

	static void DFS(int level, int sum, boolean flag) {
		if (level >= N)
			return;
		if (level == N - 1) {
			sum += arr[level];
			ans = Math.max(ans, sum);
		}

		if (level == 0) {
			DFS(level + 1, sum + arr[level], false);
			DFS(level + 2, sum + arr[level], false);
		} else {
			if (flag) {
				DFS(level + 2, sum + arr[level], false);
			} else {
				DFS(level + 1, sum + arr[level], true);
				DFS(level + 2, sum + arr[level], false);
			}

		}
	}
}
