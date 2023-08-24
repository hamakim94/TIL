package aps_220408;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1949_등산로조성 {

	static int maxLen, N, K, maxHeight; // maxLen : 최대길이, N : 등산로 크기, K : 깎는깊이, // 최대 높이
	static int[][] arr; // 등산로 높이 저장 지도
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited; // 박문철이 지도

	public static void main(String[] args) {
		// 인풋 받기
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];
			// 최대높이 초기화
			maxHeight = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					maxHeight = Math.max(maxHeight, arr[i][j]);
				}
			} // 입력 완료

			maxLen = 0;

		}
	}

	// 1.BFS 함수 만들기
	static void BFS() {

		Queue<int[]> start = new LinkedList<int[]>();

		// 최대값 좌표들 클래스에 넣어주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == maxHeight) {
					start.add(new int[] { i, j });
				}
			}
		} // 입력 완료

		// start들을 시작점으로 BFS를 돌거야
		for (int[] startPoint : start) {
			visited = new boolean[N][N];
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(startPoint);
			visited[startPoint[0]][startPoint[1]] = true;
			while (que.isEmpty()) {
				for (int i = 0; i < 4; i++) {
					int newR = startPoint[0] + dr[i];
					int newC = startPoint[1] + dc[i];
					// 범위체크
					if (newR < 0 || newR >= N || newC > 0 || newC >= N)
						continue;
					// 방문 했었니
					if (!visited[newR][newC])
						continue;

					visited[newR][newC] = true;
					que.add(new int[] { newR, newC });

				}

			}

		}

	}

	// 2. 깎기. N*N 모든 경우에 K번씩 깎아서 BFS 돌리기
}
