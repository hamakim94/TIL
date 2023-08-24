package aps_220225;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_4615_재미있는오셀로게임 {
	public static void main(String[] args) {

		// 입력 받기
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		int[][] board;

		// 시계방향 회전~~
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			board = new int[N][N];

			// 기본값 설정
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;

			// board 출력
//			for (int[] now : board) {
//				System.out.println(Arrays.toString(now));
//			}
			for (int m = 0; m < M; m++) { 

				// 이제 새로운 한 줄을 입력을 받아. 인덱스는 0부터 시작
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				int color = sc.nextInt();
				// board[r][c] = color;
				for (int i = 0; i < 8; i++) {

					int nextRow = r + dr[i];
					int nextCol = c + dc[i];
					// 만약 다음에 넣을 행 또는 열이 범위 안에 있고, 색이 다르다면
					if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
							&& board[nextRow][nextCol] == 3 - color) {
						// 좌표 담을거 만들어줌
						ArrayList<Integer> toChangeRow = new ArrayList<>();
						ArrayList<Integer> toChangeCol = new ArrayList<>();
						// 범위 안에 있고, 8방향중 한 칸 갔을 때 다른 색깔1-2, 2-1 일 때 ,행열 좌표를 따로 넣어준다
						while (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
								&& board[nextRow][nextCol] == 3 - color) {
							toChangeRow.add(nextRow);
							toChangeCol.add(nextCol);
							nextRow += dr[i];
							nextCol += dc[i];

						} // end while : 다 넣었음, 래는
//						System.out.println(toChangeRow.toString() + " " + toChangeCol.toString());

						if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
								&& board[nextRow][nextCol] == color) {
							for (int idx = 0; idx < toChangeCol.size(); idx++) {
								int nowR = toChangeRow.get(idx);
								int nowC = toChangeCol.get(idx);
								board[nowR][nowC] = color;
							} // end for : 중간 색 바꿔주기
//								// 다 돌고 나서 바꿔주기
							board[r][c] = color;
						} // end if : 색 바꿔주기
					} // end if : 만약 8방향 중 하나가 색이 다른 경우 해줌;

				} // end for : 8방향 탐색 완료
					// board 출력
				

			} // end for : 예시 다 입력 완료
			int countB = 0;
			int countW = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						countB++;
					} else if (board[i][j] == 2) {
						countW++;
					}
				}
			}
			System.out.println("#" + tc + " " + countB + " " + countW);
		}
	}
}
