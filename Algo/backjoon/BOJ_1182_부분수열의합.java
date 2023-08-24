package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N, total, ans, cnt; // 수열의 개수, 합, 개수
	static int[] arr; // 수열
	static boolean[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		total = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		powerset(0, 0);
		System.out.println(ans);
	}

	static void powerset(int level, int sum) {
		if (level == N) {
			if(sum == total && cnt > 0) ans++;
			return;
		}
		sel[level] = true;
		cnt++;
		powerset(level + 1, sum + arr[level]);
		sel[level] = false;
		cnt--;
		powerset(level + 1, sum);

	}
}
