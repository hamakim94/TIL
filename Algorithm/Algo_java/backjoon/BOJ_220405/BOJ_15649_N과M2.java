package BOJ_220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649_N과M2 {

	static int N;
	static int M;
	static int[] nums; // 기본 열
	static int[] ans; // 개수
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] now = br.readLine().split(" ");
		N = Integer.parseInt(now[0]);
		M = Integer.parseInt(now[1]);
		// System.out.println(N + " " + M);
		// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		ans = new int[M];
		perm(0,0);
		System.out.println(sb);

	}

	// idx : nums배열 가지고 놀거, sdix : ans의 idx
	static void perm(int idx, int sidx) {
		// base
		if (sidx == M) {
			for (int i : ans) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		if (idx == N) {
			return;
		}
		// recursion
		ans[sidx] = nums[idx];
		
		perm(idx + 1, sidx + 1);
		perm(idx + 1, sidx);

	}
}
