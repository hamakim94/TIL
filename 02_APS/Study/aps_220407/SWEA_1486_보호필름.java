package aps_220407;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1486_보호필름 {

	static int D, W, K; // D : 두께(3<=D<=13), W:가로크기(1<=W<=20), K:합격기준(1<=K<=D)
	static int minVal; // 최소바꿈횟수
	static boolean[] checked;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			D = sc.nextInt();// 두께(높이)
			W = sc.nextInt(); // 가로크기.
			K = sc.nextInt(); // 합격기준, 높이방향(세로) 연속 ..

			// 입력 완료
			int[][] film = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // end input

			// 하고싶은거, D의 퍼뮤테이션을 통해서
			// 해당 행 전부다 0으로 바꾸고
			// 되돌리기
			// 해당 행 전부다 1로 바꾸고
			// 되돌리기.

			// 체크오케이 돌아감.
//			if (checkOk(film)) {
//				System.out.println(tc);
//			}
//			film = changeAB(film, 1, 1);
//			for(int d=0; d<D; d++) {
//				System.out.println(Arrays.toString(film[d]));
//			}
			checked = new boolean[D];
			minVal = Integer.MAX_VALUE;
			change(film, 0);
			System.out.println("#" + tc + " " + minVal);

		} // end testCase

	} // end main

	// 하고싶은거, D의 퍼뮤테이션을 통해서
	// 해당 행 전부다 0으로 바꾸고
	// 되돌리기
	// 해당 행 전부다 1로 바꾸고
	// 되돌리기.
	static void change(int[][] arr, int idx) {
		// 가지치기
		if (idx > minVal) {
			return;
		}
		if (idx == D) {
			return;
		}

		// 체크가 잘 됐으면, 그냥 idx 나오렴!
		if (checkOk(arr) == true) {

			minVal = Math.min(minVal, idx);
			return;
		}

		for (int d = 0; d < D; d++) {
			if (!checked[d]) {
				checked[d] = true;
				// 여기서 매번 새로운 주소를 만들어줘야 가능함..
				int[][] B1 = new int[D][W];
				int[][] B2 = new int[D][W];
				for (int i = 0; i < D; i++) {
					for (int j = 0; j < W; j++) {
						B1[i][j] = arr[i][j];
						B2[i][j] = arr[i][j];
					}
				}

				change(changeAB(B1, d, 0), idx + 1);
				change(changeAB(B2, d, 1), idx + 1);
				checked[d] = false;
			}
		}

	}

	// 주어진 행을 특정한 원하는 숫자로 바꾸는 함수
	static int[][] changeAB(int[][] arr, int row, int number) {
		// 가로 : W
		// 세로 : D
		for (int w = 0; w < W; w++) {
			arr[row][w] = number;
		}

		return arr;
	}

	// 주어진 배열이 시험에통과할 수 있는지, 없는지 체크하는 함수
	static boolean checkOk(int[][] arr) {
		// 가능한 가로 사이즈 담아두는 숫자
		int cnt = 0;
		// 가로만큼 돌면서,
		for (int w = 0; w < W; w++) {
			inner: for (int d = 0; d <= D - K; d++) {
				// 세로방향 K개만큼의 합.
				int num = 0;
				for (int i = d; i < d + K; i++) {
					num += arr[i][w];
				}
				// 여기서 되는 조건, K개 연속된 값들의 합이 K와 같거나, 0인경우
				if (num == 0 || num == K) {
					cnt++;
					break inner;
				}

			}
		}
		// 가능한 것의 개수가 가로 크기와 같으면, 통과!
		if (cnt == W) {
			return true;
		}
		return false;

	}
}
