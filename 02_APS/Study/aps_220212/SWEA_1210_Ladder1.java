package aps_220212;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {

		// 2에서 시작해서, 왼쪽, 오른쪽, 위만 올라갈거야
		Scanner sc = new Scanner(System.in);
		// testCase 10번
		int input = 0;
		for (int t = 0; t < 10; t++) {
			input = sc.nextInt();
			// 우선 배열을 입력 받아야함

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 하고싶은 일 :
			// 시작 열 찾기 r, c
			int[] start = new int[2];
			start[0] = 99;
			// 99번쨰 행에서 부터 시작해서 2를 찾는다

			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					start[1] = i;
					break;
				}
			}
			// 2. 그 행에서 dr = {0, 0, -1} dc = {-1, 1, 0} 순으로 순회한다(왼쪽, 오른쪽, 위)
			int[] dr = { 0, 0, -1 };
			int[] dc = { -1, 1, 0 };
			// 순회할 열과 행
			int nr;
			int nc;
			// 갔던 곳 표시할 board 생성
			int[][] board = new int[100][100];
			board[start[0]][start[1]] = 1;

			while (start[0] >= 1) {
				for (int i = 0; i < 3; i++) {
					nr = start[0] + dr[i];
					nc = start[1] + dc[i];
					// 3. 1을 찾으면, 다음 좌표는 그 위치가 된다.
					if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && arr[nr][nc] == 1 && board[nr][nc] == 0) {
						board[nr][nc] = 1;
						start[0] = nr;
						start[1] = nc;
						//System.out.println(Arrays.toString(start));
					}
				}
			}// 4. 행이 0이면 종료, 그 열을 반환한다.
			System.out.println("#" + input + " " + start[1]);
		}
		sc.close();
	}
	
}
