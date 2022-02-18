package aps_220211;

import java.util.Scanner;

public class SWEA_1209_Sum {
	public static void main(String[] args) {
		// 우선 100*100 행렬을 만들고, 입력을 받아야함

		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int testCase = sc.nextInt();

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 최대값:
			int max = 0;
			// 행 열의 합
			for (int r = 0; r < 100; r++) {
				int rowSum = 0;
				int colSum = 0;
				for (int c = 0; c < 100; c++) {
					rowSum += arr[r][c];
					colSum += arr[c][r];
				}
				if (max < rowSum) {
					max = rowSum;
				}
				if (max < colSum) {
					max = colSum;
				}
			}
			// 대각합 / 역대각합
			int diagSum = 0;
			int revDiagSum = 0;
			for (int r = 0; r < 100; r++) {
				diagSum += arr[r][r];
				revDiagSum += arr[99 - r][r];
			}
			if (max < diagSum) {
				max = diagSum;
			}
			if (max < revDiagSum) {
				max = revDiagSum;
			}
			System.out.println("#" + testCase + " " + max);
		}

	}
}
