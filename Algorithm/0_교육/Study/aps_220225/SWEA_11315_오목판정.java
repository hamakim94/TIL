package aps_220225;

import java.util.Scanner;

public class SWEA_11315_오목판정 {

	public static char[][] board;
	public static int N;
	public static int[] dr = { 0, 1, 1, 1 };
	public static int[] dc = { 1, 1, 0, -1 };

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			// size
			N = sc.nextInt();

			// input
			board = new char[N][];

			for (int i = 0; i < N; i++) {
				board[i] = sc.next().toCharArray();

			} // end for : input finish
			boolean flag = false;
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 함수를 만들자
					if (board[i][j] == 'o' && isFive(i, j)) {
						flag = true;
						System.out.println("#" + tc + " " + "YES");
						break outer;
					}
				}
			} // end for : 오목판정
			if (!flag) {
				System.out.println("#" + tc + " " + "NO");
			}

		} // end testCases
	} // end main

	public static boolean isFive(int row, int col) {

		// 행 열을 입력값으로 받고,
		// 딱 4번만 더 돌겠어
		for (int i = 0; i < 4; i++) {
			int cnt = 1;

			for (int k = 1; k < 5; k++) {
				int newRow = row + dr[i] * k;
				int newCol = col + dc[i] * k;

				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && board[newRow][newCol] == 'o') {
					cnt += 1;
				}
			}
			if (cnt == 5) {
				return true;
			}

		}

		return false;
	}
}
