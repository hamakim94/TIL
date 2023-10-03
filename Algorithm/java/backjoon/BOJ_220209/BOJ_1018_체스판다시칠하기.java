package BOJ_220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		// 목표 1 8*8 이차원 배열 만들기

		// 8*8 배열 선언
		boolean[][] arr = new boolean[8][8];
		boolean flag = true;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				arr[i][j] = flag;
				flag = !(flag);
			} // end for , 다 돌면 하나 더 바꿔
			flag = !(flag);
		} // end for

//		for (int i=0; i<8; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		// 이제 한 번 입력을 받아보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[n][m];

		// 현재 줄을 받기 위한 String
		String currentLine;
		for (int i = 0; i < n; i++) {
			currentLine = br.readLine();
			for (int j = 0; j < m; j++) {
				if (currentLine.charAt(j) == 'B') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}

		} // end for : make board(t/f)
			// 함 출력해보기
//		for (int i =0; i<n; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}

		// 이제 행수 -8, 열수 - 8까지 for 문을 돌면서 만든 함수를 써서, 최소값을 찾아야해
		int min = 2501;
		int currentNum = 0;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				currentNum = returnNum(i, j, board, arr);
				if (currentNum < min) {
					min = currentNum;
				}
			}
		}

		System.out.println(min);

	}

	// 해당 함수는 row,col부터 8개씩 board를 순회해
	// 1. 기존에 만들어놓은 arr과 비교
	public static int returnNum(int row, int col, boolean[][] board, boolean[][] arr) {
		int cnt = 0;
		for (int r = row; r < row + 8; r++) {
			for (int c = col; c < col + 8; c++) {
				if (board[r][c] == arr[r - row][c - col]) {
					cnt += 1;
				}
			}
		} // end for
			// 2. 개수 새고, 64 - 해당 개수까지 세
			// 그 중 작은값을 찾아서 반환하는 함수를 만들고싶다.
		if (cnt <= 64 - cnt) {
			return cnt;
		}
		return 64 - cnt;
	}
}
