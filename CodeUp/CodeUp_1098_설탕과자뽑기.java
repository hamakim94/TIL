package codeup_0120;

import java.util.Scanner;

public class CodeUp_1098_설탕과자뽑기 {
	public static void main(String[] args) {

		// 우선, 여러가지 입력을 받자

		Scanner sc = new Scanner(System.in);

		// 배열의 높이, 즉 row, 배열의 가로(w) : 열 개수
		int h = sc.nextInt();
		int w = sc.nextInt();

		// 배열을 만들자
		int[][] arr = new int[h][w];

		// 막대개수
		int n = sc.nextInt();

		// 여기서부터 반복문 돌아야해
		for (int i = 0; i < n; i++) {
			int len = sc.nextInt();

			// 방향 : 가로 : 0, 세로 : 1
			int d = sc.nextInt();

			// x좌표 y좌표,
			int x = sc.nextInt() - 1; // 행 : 이거 떄문에 오지게 해맸다
			int y = sc.nextInt() - 1; // 열
	

			// 한 번에 하지 말고, 일단 최대 x값을 찾아보자
			if (d == 0) { // 가로
				int max_y = y + len;
				if (max_y <= w) {   // 이거 안 넣어서, 혹시 모르니까 항상 확인
					for (int j = y; j < max_y; j++) {
						arr[x][j] = 1;
					}
				}
			} else {
				int max_x = x + len;
				if (max_x <= h) { // 이거 안 넣어서, 혹시 범위때문에 항상 확인
					for (int j = x; j < max_x; j++) {
						arr[j][y] = 1;
					}
				}

			}

		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) { // 여기서 h, w 문제 케이스 때문에 틀림
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}