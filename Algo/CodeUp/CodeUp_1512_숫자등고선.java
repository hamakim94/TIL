package codeup_0120;

import java.util.Scanner;

public class CodeUp_1512_숫자등고선 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 행렬 만들기
		int[][] ch = new int[n + 1][n + 1];
		int[][] board = new int[n + 1][n + 1];

		int r = sc.nextInt();
		int c = sc.nextInt();

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		ch[r][c] = 1;
		board[r][c] = 1;

		// 일단 한 번만 돌아보자

		for (int i = 1; i < n + 1; i++) {
			for (int k = 0; k < 4; k++) {
				int new_r = r + i * dr[k];
				int new_c = c + i * dc[k];
				if (new_r >= 0 && new_r < n + 1 && new_c >= 0 && new_c < n + 1 && ch[new_r][new_c] == 0) {
					ch[new_r][new_c] = 1;
					board[new_r][new_c] = board[r][c] + i;
				}
			}
		}
		// 한 번 돈 행에서 같은 반복을 계속적으로 한다.
		for (int t = 1; t < n + 1; t++) {
			c = t;
			for (int i = 1; i < n + 1; i++) {
				for (int k = 0; k < 4; k++) {
					int new_r = r + i * dr[k];
					int new_c = c + i * dc[k];
					if (new_r >= 0 && new_r < n + 1 && new_c >= 0 && new_c < n + 1 && ch[new_r][new_c] == 0) {
						ch[new_r][new_c] = 1;
						board[new_r][new_c] = board[r][c] + i;
					}
				}
			}

		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
