package aps_220225;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전여러풀이 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();

				}
			} // end for : 입력

			String[][] ans = new String[N][3];
			StringBuilder sb = new StringBuilder();
			// 내용 비우기
			// 1. 새롭게 enw
			// 2. delete
			// 3. setLength
			for (int idx = 0; idx < 3; idx++) {
				map = rotation(map);

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						sb.append(map[i][j]);
					}
					ans[i][idx] = sb.toString();
					sb.setLength(0);
				}
			} // end for : 이기

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	} // end main

	// 90도 돌리고, 해당 2차원 배열을 반환하는 메또드
	public static int[][] rotation(int[][] map) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[N - 1 - j][i];
			}
		}
		return tmp;
	}
}
