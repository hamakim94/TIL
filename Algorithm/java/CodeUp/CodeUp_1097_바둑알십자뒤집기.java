package codeup_0120;

import java.util.Scanner;

public class CodeUp_1097_바둑알십자뒤집기 {
	public static void main(String[] args) {

		// 우선, 19x19 2차원 배열 입력받아야함
		Scanner sc = new Scanner(System.in);

		// 받기위한 초기화
		int[][] arr = new int[19][19];

		// 받자
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 몇 개 바꿀래?
		int n = sc.nextInt();

		// 반복을 통해 숫자 2개 받자
		for (int i = 0; i < n; i++) {
			// 여기서 10번째는 index 9를 가리켜야 함
			int dr = sc.nextInt() - 1;
			int dl = sc.nextInt() - 1;

			// 행 싸아악~
			for (int r = 0; r < 19; r++) {
				int tmp = (arr[r][dl] == 0) ? 1 : 0;
				arr[r][dl] = tmp;
			}
			// 열 싸아악~
			for (int l = 0; l < 19; l++) {
				int tmp = (arr[dr][l] == 0) ? 1 : 0;
				arr[dr][l] = tmp;
			}
		}

		// 출력
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}
}
