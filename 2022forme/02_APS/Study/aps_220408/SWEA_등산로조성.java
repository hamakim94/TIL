package aps_220408;

import java.util.Scanner;

public class SWEA_등산로조성 {
	static int N, K, maxH, ans; // 한 변의 길이, 최대 공사 깊이, 가장 높은 봉우리, 정답
	static int[][] mountain; // 산
	static boolean[][] visited; // 박문철이
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			maxH = 0; // 가장 높은 봉우리를 저장하겠다?
			ans = 0; // 정답 초기화
			mountain = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					if (maxH < mountain[i][j])
						maxH = mountain[i][j];
				}
			} // 입력 완료, 최대 높이까지 찾음

			// 등산로 조성 시도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mountain[i][j] == maxH) {
						// 좌표 거리 스킬
						crash(i, j, 1, true);
					}

				}
			}
			System.out.println("#" + tc + " " + ans);

		} // end testCase
	} // end main

	// 행 열 좌표, dist 지금까지 온 거리, skill : 내가 사용 할 수 있는지~
	private static void crash(int r, int c, int dist, boolean skill) {

		if (dist > ans) {
			ans = dist;
		}

		visited[r][c] = true; // 방문처리
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 범위 벗어났고 방문처리된거면 넘어가~
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
				continue;

			// 1. 다음 좌표의 높이가 나보다 낮을 때 ...
			if (mountain[r][c] > mountain[nr][nc])
				crash(nr, nc, dist + 1, skill); // 그냥 가지고 있는 값 그대로 넣으면 됨
			// 2. 다음 좌표가 나보다 같거나 높을 때...
			// 2-1. 공사 할 수 있는 기회가 있는지
			// 2-2. 공사 하면 견적은 나오는지
			else if (skill && mountain[r][c] > mountain[nr][nc] - K) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[r][c] - 1; // 여러번 파볼 필요 없음
				crash(nr, nc, dist + 1, false);
				mountain[nr][nc] = tmp; // 원상복구
			}
		}

		visited[r][c] = false; // 방문처리 out

	}
}
