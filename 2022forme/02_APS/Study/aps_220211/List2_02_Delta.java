package aps_220211;

public class List2_02_Delta {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// N*N 크기이니
		int N = arr.length;
		// 현재 좌표
		int r = 1;
		int c = 1;

		// 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int d = 0; d < 4; d++) {
			// 다음 좌표는 현재 좌표 + 델타
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			int nr2 = r + drc[d][0]; // 행
			int nc2 = c + drc[d][1]; // 열
			// 항상 배열의 경계를 벗어나진 않는지 체크해야함
			// System.out.println(arr[nr][nc]);

			// 확인법 2가지!!
			// 1. 맵(배열) 안에 들어왔으면 해!
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}

			// 2. 맵(배열)을 벗어났으면 이번에는 넘어가!
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			System.out.println();
		}
	}
}
