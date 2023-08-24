package BOJ_220511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N, normal, redgreen; // 배열의 크기, 적록색약 아님, 적록색약
	static char[][] arr, arrRedgreen; // 전체 입력 map, 색약맵
	static boolean[][] vNormal, vRedgreen; // 방문처리 : 정상/적록색약
	static int[] dr = { -1, 0, 1, 0 }; // 행의 움직임
	static int[] dc = { 0, -1, 0, 1 }; // 열의 움직임
	// 좌표

	static class Dot {
		int r;
		int c;

		Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		normal = redgreen = 0; // 개수 0으로 초기화
		arr = new char[N][N]; // 새로 배열 선언
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		} // end for : 입력 완료
		arrRedgreen = new char[N][N]; // 적록색약인경우의 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G') { // 그린이면 R로 바꿔서 보겠다
					arrRedgreen[i][j] = 'R';
				} else {
					arrRedgreen[i][j] = arr[i][j];
				}
			}
		}
		vNormal = new boolean[N][N];
		vRedgreen = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 방문 안 했다면
				if (!vNormal[r][c]) // 정상인경우 BFS
					BFS(r, c, true);
				if (!vRedgreen[r][c]) // 색약인경우 BFS
					BFS(r, c, false);
			}
		}
		System.out.println(normal + " " + redgreen);

	}// end main

	static void BFS(int r, int c, boolean flag) {
		if (flag) { // 정상인 경우
			Queue<Dot> q = new LinkedList<>();
			char start = arr[r][c]; // 시작점
			q.add(new Dot(r, c)); // que에 넣어주기
			vNormal[r][c] = true; // 박문철이
			normal++; // 블록 세기!
			while (!q.isEmpty()) {
				Dot now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || vNormal[nr][nc]) // 범위 out/방문했으면 나가!
						continue;
					if (arr[nr][nc] == start) { // 다음 좌표가 시작점이랑 같아?
						vNormal[nr][nc] = true; // 갈 곳 박문철이
						q.add(new Dot(nr, nc)); // que에 더해주기
					}
				}
			} // end while
		} // end if
		else { // 색약인 경우는, 배열. 카운트하는 변수, 박문철이 하는 배열이 redgreen이 들어간걸로 바뀌면 됨
			Queue<Dot> q = new LinkedList<>();
			char start = arrRedgreen[r][c];
			q.add(new Dot(r, c));
			vRedgreen[r][c] = true;
			redgreen++;
			while (!q.isEmpty()) {
				Dot now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || vRedgreen[nr][nc])
						continue;
					if (arrRedgreen[nr][nc] == start) {
						vRedgreen[nr][nc] = true;
						q.add(new Dot(nr, nc));
					}
				}
			} // end while
		}
	}

}
