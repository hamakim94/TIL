package aps_220217;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {

		// 인풋 받기
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int boardSize; // 전체 판의 크기
		int windowSize; // 파리채의 크기
		int[][] board; // 판 받기

		int max; // 케이스별 최대값
		int now; // 파리채 딱! 별 죽은 파리의 개수를 더하기 위한 변수

		int maxIdx; // 인덱스의 최대값
		for (int tc = 1; tc <= testCase; tc++) {

			boardSize = sc.nextInt();
			windowSize = sc.nextInt();
			board = new int[boardSize][boardSize];
			for (int i = 0; i < boardSize; i++) {
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = sc.nextInt();
				}
			} // end for : 입력 완료

			// 5, 2인 경우, 0부터 n-m 까지 for문 3개 돌면서, window_size만큼
			maxIdx = boardSize - windowSize + 1;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < maxIdx; i++) {
				for (int j = 0; j < maxIdx; j++) {
					// r, c :
					now = 0;
					for (int r = 0; r < windowSize; r++) {
						for (int c = 0; c < windowSize; c++) {
							now += board[i + r][j + c];
						}
					} // end for : window 내부 합 구함
					if (max < now) {
						max = now;
					} // 최댓값

				}
			}
			System.out.println("#" + tc + " " + max);

		} // end for : testCase 종료;

	}
}
