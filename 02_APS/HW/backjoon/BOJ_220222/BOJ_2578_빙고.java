package BOJ_220222;

import java.util.Scanner;

public class BOJ_2578_빙고 {
	public static void main(String[] args) {
		// 허세 ㄴㄴ 그냥 for문 돌자
		Scanner sc = new Scanner(System.in);

		int[][] bingo = new int[5][5];
		// 담기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}

		}
		// 개수 세기
		int cnt = 0;
		// 이제 for문 돌면서 들어가자
		while (true) {
			int now = sc.nextInt(); // 하나 받고
			cnt++; // 센 개수 1 더해주고
			// for문 돌면서, 그 값과 빙고가 같으면 0 넣어주기
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == now) {
						bingo[i][j] = 0;

					}
				}
			} // end for : 0 대입 완료
			
//			Q) 이거 넣으니까 안 되는데, 딱 12개로 빙고가 가능한가..? 뭐지?
//			if( cnt < 13) { // 최소 13개를 넣어야지 빙고가 나와
//				continue;
//			}
			if (isBingo(bingo)) {
				System.out.println(cnt);
				break;
			}
		}

	}

	// 빙고 세기 함수
	public static boolean isBingo(int[][] arr) {
		// 행 합이 0이면, 빙고수 count ++;
		// 열 합이 0이면, 빙고수 count ++
		// 대각합이 0
		int cnt = 0;
		int diag1Sum = 0; // 대각선1
		int diag2Sum = 0; // 대각선2
		for (int i = 0; i < 5; i++) {
			// 열의 합 구하기
			int colSum = 0;
			for (int j = 0; j < 5; j++) {
				colSum += arr[i][j];
			}
			if (colSum == 0) {
				cnt++;
			}

			int rowSum = 0;
			// 행의 합(세로들의 합)
			for (int j = 0; j < 5; j++) {
				rowSum += arr[j][i];
			}
			if (rowSum == 0) {
				cnt++;

			}
			// 대각합1
			diag1Sum += arr[i][i];
			// 대각합2
			diag2Sum += arr[4 - i][i];

		} // end for : 빙고 개수 세기 완료
		if (diag1Sum == 0) {
			cnt++;
		}
		if (diag2Sum == 0) {
			cnt++;
		}
		if (cnt >= 3) {
			return true;
		}
		return false;
	}
}
