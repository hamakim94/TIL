package BOJ_220707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형_DFS {
	static int[][] arr;
	static int N;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, 0, 0);
		System.out.println(ans);
	}

	static void DFS(int level, int idx, int sum) {
		if (level == N) {
			if (sum > ans)
				ans = sum;
			return;
		}
		sum += arr[level][idx];
		DFS(level + 1, idx, sum);
		DFS(level + 1, idx + 1, sum);

	}
}
