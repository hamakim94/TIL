package BOJ_220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

	static class Vege {
		int m;
		int n;

		public Vege(int m, int n) {
			this.m = m;
			this.n = n;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int[][] arr;
	static int M, N, K, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			ans = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				arr[m][n] = 1;
			}

			// BFS
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0)
						BFS(i, j);
				}
			}
			System.out.println(ans);

		} // end testCase
	} // end main

	private static void BFS(int m, int n) {
		Queue<Vege> que = new LinkedList<>();
		que.add(new Vege(m, n));
		arr[m][n] = 0; // 박문철2
		ans++;
		while (!que.isEmpty()) {
			Vege now = que.poll();
			for (int i = 0; i < 4; i++) {
				int nm = now.m + dr[i];
				int nn = now.n + dc[i];

				if (nm < 0 || nm >= M || nn < 0 || nn >= N)
					continue;
				if (arr[nm][nn] == 0)
					continue;
				que.add(new Vege(nm, nn));
				arr[nm][nn] = 0;

			}
		}
	}
}
