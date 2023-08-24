package BOJ_220702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int N, M, maxi;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// 결국 위로 한 칸, 아래 한칸, 즉 4방향 DFS같아
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxi = Integer.MIN_VALUE;
		// 각 칸에서, 4칸씩 돌려야 함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				DFS(i, j, 0, 0);
				cross(i, j);
			}
		}
		System.out.println(maxi);
	}

	static void DFS(int r, int c, int sum, int cnt) {
		if (cnt == 4) {
			maxi = Math.max(maxi, sum);
			return;
		}

		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (visited[nr][nc])
				continue;
			DFS(nr, nc, sum + map[r][c], cnt + 1);
		}
		visited[r][c] = false;
	}

	static void cross(int r, int c) {
		int cnt = 0;
		// 주변 개수 세기
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				cnt++;
		}
		if (cnt == 1) {
			int sum = map[r][c];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				sum += map[nr][nc];
				maxi = Math.max(sum, maxi);
			}
		} else if (cnt == 0) {
			int sum = map[r][c] + map[r + 1][c] + map[r - 1][c] + map[r][c + 1] + map[r][c - 1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				System.out.println(sum - map[nr][nc]);
				maxi = Math.max(sum - map[nr][nc], maxi);
			}
		}

	}
}
