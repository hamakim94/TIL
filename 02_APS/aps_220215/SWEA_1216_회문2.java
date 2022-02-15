package aps_220215;

import java.util.Scanner;

public class SWEA_1216_회문2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = 100; // 100*100
		int forCount; // size/2. 반복문을 돌 갯수
		char[][] arr; // 입력을 받을 배열;
		boolean flagRow;
		boolean flagCol;
		int size; // 회문의 사이즈
		String str; // 입력을 위한 스트링
		
		for (int tc = 1; tc <= 10; tc++) {
			int temp = sc.nextInt();
			arr = new char[N][N];
			// 입력받기
			for (int i = 0; i < 100; i++) {
				str = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			size = 100;
			// for문을 돌기위한 j의 갯수
			
			st: while (size >= 1) {
				forCount = size / 2;
				// 행우선, 모든 행에 대해서~
				for (int i = 0; i < N; i++) {
					// N - size 까지만 돌거야
					for (int j = 0; j < N - size + 1; j++) {
						flagRow = true;
						flagCol = true;
						
						for (int k = 0; k < forCount; k++) {
							if (arr[i][j + k] != arr[i][j + size - 1 - k]) {
								flagRow = false;
								break;
							} // end if : 회문 검사
						} //
						if (flagRow) {
							System.out.println("#" + tc + " " + size);
							break st;
						}
						
						for (int k = 0; k < forCount; k++) {
							if (arr[j + k][i] != arr[j + size - 1 - k][i]) {
								flagCol = false;
								break;
							} // end if : 회문 검사
						} //
						if (flagCol) {
							System.out.println("#" + tc + " " + size);
							break st;
						}
					}

				}
				size--; // 1씩 감소
			}
		}

	}
}