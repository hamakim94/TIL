package aps_220215;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		// 오른쪽, 아래, 왼쪽, 위 순서대로.
		Scanner sc = new Scanner(System.in);

		// 입력받는 테스트케이스 수
		int testCase = sc.nextInt();

		int[][] arr; // 1,2,3,4 넣을거
		int[][] board; // 갔으면 1, 아니면 0

		// 움직일 델타를 위한 변수 선언
		int new_r; // 새로운 row idx
		int new_c; // 새로운 col idx
		int cnt; // 1씩 증가시켜 넣을 값
		int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상으로
		int[] dc = { 1, 0, -1, 0 }; // 우, 하, 좌, 상으로
		int idx;
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt();
			idx = 0;
			arr = new int[n][n];
			board = new int[n][n];

			cnt = 1; // 일단 맨 왼쪽 위 1 박고
			new_r = 0;
			new_c = 0;
			board[new_r][new_c] = 1; // 여긴 이미 1로 처리했으니 체크됨
			arr[0][0] = 1; // 1로 넣고 시작해보자

			// 배열의 총 수만큼만 돌자
			while (cnt < n * n) {
				// 탐색
				// 한 열당, 최대 n번 도니 for문으로 설정.
				for (int i = 0; i < n; i++) {
					new_r += dr[idx];
					new_c += dc[idx];

					// board가 0이면 가, 1이면 이미 간 곳이므로 가지 마!
					if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < n && board[new_r][new_c] == 0) {
						board[new_r][new_c] = 1;
						arr[new_r][new_c] = ++cnt;
						break;
					} else {
						// 다시 빼 줘야지, 원래 좌표로 돌아가 for문을 돌 수 있음
						new_r -= dr[idx];
						new_c -= dc[idx];
						// idx + 1한걸 4로 나눈 나머지로 설정해서 우,하,좌,상 방향으로 돌게 설정!
						idx = (idx + 1) % 4;
					}
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
