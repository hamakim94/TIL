package aps_220410;

import java.util.Scanner;

public class SWEA_1949_등산로조성 {

	static int N, K; // 지도크기, 지도개수
	static int[][] map; // 지도
	static boolean[][] visited; // 방문처리
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int maxVal, maxHeight; // 정답 최대 길이 / 최대 높이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 입력 및 초기화
			N = sc.nextInt();
			K = sc.nextInt();
			maxHeight = 0;
			maxVal = 0;
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			} // 입력 완료 / 최대 높이 찾기 완료

			// for문을 돌면서, 각 최대 높이를 구하자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						visited[i][j] = true;
						go(i, j, 1, false);
						visited[i][j] = false;
					}

				}
			}
			System.out.println("#" + tc + " " + maxVal);
		} // end testCase

	}// end main

	private static void go(int r, int c, int cnt, boolean skill) {
		// 하고싶은거 : 최대값 비교
		maxVal = Math.max(maxVal, cnt);
		// for문을 돌거고, 한 뎁스갈때마다 길이 + 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 범위체크, 방문 안 했으면..!
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
				continue;
			// 나보다 숫자 작은 경우엔 그냥 가보렴.
			if (map[r][c] > map[nr][nc]) {
				// 박문철이
				visited[nr][nc] = true;
				go(nr, nc, cnt + 1, skill);
				visited[nr][nc] = false;
			}
			// 숫자가 크거나 같니 ? 현재  높이보다 1작게 깎을 수 있다면
			else if (!skill && map[nr][nc] - map[r][c] < K ) {
				// 원래값을 저장해놓고
				int temp = map[nr][nc];
				// 박문철이
				visited[nr][nc] = true;
				// 깎기
				map[nr][nc] = map[r][c] - 1;
				// 여기서, !skill 로 들어가야함. 내가 깎았는지 안 깎았는지 그 상태를 들고다녀야하기 때문
				go(nr, nc, cnt + 1, !skill);
				// 끝났니? 다시 안간걸로
				visited[nr][nc] = false;
				// 원래값으로 돌려주렴
				map[nr][nc] = temp;
			}

		}


	}
}
