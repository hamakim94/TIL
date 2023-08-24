package aps_220413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_보급로 {
	// 행열순회
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static final int INF = Integer.MAX_VALUE; // 초기값
	static boolean[][] visited; // 박문철이
	static int[][] arr; // 기존 깊이(걸리는 시간)
	static int[][] minTime; // 최소 거리 저장 배열
	static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			arr = new int[N][N];
			minTime = new int[N][N];
			for (int i = 0; i < N; i++) {
				// 초기값 설정해주기, 무한대로 큰 값으로
				Arrays.fill(minTime[i], INF);
				// 배열 입력 받기
				String now = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = now.charAt(j) - '0';
				}

			}

			// 계획
			// 이제 0,0 부터 시작하고, (minTime[0][0] = 0 넣고 시작)
			minTime[0][0] = 0;
			// 2중for문 돌면서 최소값 인덱스 찾아.
			// 이걸 N*N -1번 돌아볼까..
			for (int t = 0; t < N * N - 1; t++) {
				int minVal = INF;
				int[] minIdx = { -1, -1 };
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && minVal > minTime[i][j]) {
							minVal = minTime[i][j];
							minIdx = new int[] { i, j };
						}
					}
				}
				// 함 해보자
				
				
				int r = minIdx[0];
				int c = minIdx[1];
				
				
				// 거기 박문철이
				visited[r][c] = true;
				
				if(r == N-1 && c == N-1) break;
				// System.out.println("r : " + r + " c : " + c);
				//
				q = new LinkedList<int[]>();
				// 2. 그 최소값 인덱스에서 4방향 돌면서
				for (int i = 0; i < 4; i++) {
					// 2-1. 범위탐색 && 박문철이 안 돼있으면 que에 넣어.
					int newR = r + dr[i];
					int newC = c + dc[i];

					if (newR < 0 || newR >= N || newC < 0 || newC >= N)
						continue;
					if (visited[newR][newC])
						continue;
					q.add(new int[] { newR, newC });

				}
				// 2-2. que에 비어있을 때 까지
				while (!q.isEmpty()) {
					int[] now = q.poll();
					// 인접한 다음 좌표
					int rr = now[0];
					int cc = now[1];
					// 2-3. que.poll 해서
					// 거기서 4방향 탐색해서,(마찬가지, 박문철이, 범위확인)

					// 내 현재 앞으로 갈 값 > 현재 poll한 minTime + 갈때 걸리는 시간
					// minTime[갈곳] = poll한 minTime + 갈때 걸리는 시간
					if (minTime[rr][cc] > minTime[r][c] + arr[rr][cc]) {
						minTime[rr][cc] = minTime[r][c] + arr[rr][cc];
					}
					// 언제까지가 헷갈리네.

				} // end while : que 비우기 완료, 한 칸에서 4방향 최솟값 구함.
//				System.out.println(t);
//				for(int i=0; i<N; i++) {
//					
//					System.out.println(Arrays.toString(minTime[i]));
//				}
			} // end for : 무한반보쿠
			System.out.println("#" + tc + " " + minTime[N - 1][N - 1]);
		} // end testCase

	}
}
