package codeup_0120;

import java.util.Scanner;

public class CodeUp_1512_숫자등고선2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 행렬 만들기
		int[][] ch = new int[n][n];

		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		
		// 그냥 거리로 생각하니까 되네..
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				ch[i][j] = Math.abs(r - i) + Math.abs(c - j) + 1;
			}
		}

		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
	}

}
