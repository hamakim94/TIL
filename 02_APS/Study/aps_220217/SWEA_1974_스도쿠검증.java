package aps_220217;

import java.util.HashSet;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) {
		// 행들 먼저 HashSet에 add해서 size가 9인지
		// 열들 먼저 HashSet에 add해서 size가 9인지
		// 9칸씩 어떻게 할까, 인덱스 : 0, 3, 6 : 0; 3; 6씩 돌면서, 그 안에서 for문 2번씩 돌고, set에 add
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		HashSet<Integer> hashsetRow; // 행검사
		HashSet<Integer> hashsetCol; // 열검사
		HashSet<Integer> hashsetBox; // 박스검사 9칸
		for (int tc = 1; tc <= testCase; tc++) {
			// 입력받을 배열 선언 및 인풋 받기
			boolean flag = true;
			int[][] arr = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 행

			bigone: while (true) {
				for (int i = 0; i < 9; i++) {
					hashsetRow = new HashSet<>();
					hashsetCol = new HashSet<>();
					for (int j = 0; j < 9; j++) {
						hashsetRow.add(arr[i][j]);
					}
					for (int j = 0; j < 9; j++) {
						hashsetCol.add(arr[j][i]);
					}
					// 하나씩 더해주고, 9개가 아니면 flag false, 그다음 출력, while문 끝
					if (hashsetRow.size() != 9) {
						System.out.println("#" + tc + " " + 0);
						flag = false;
						break bigone;
					}
					if (hashsetCol.size() != 9) {
						System.out.println("#" + tc + " " + 0);
						flag = false;
						break bigone;
					}
				}

				// 이제 대각선 검사
				for (int i = 0; i < 9; i = i + 3) {
					for (int j = 0; j < 9; j = j + 3) {
						// 0, 3, 6 인덱스에서 3칸씩 넣는 박스
						hashsetBox = new HashSet<>();
						for (int t = 0; t < 3; t++) {
							for (int k = 0; k < 3; k++) {
								hashsetBox.add(arr[t][k]);
							}
						}
						// 사이즈 9개 아니면 그냥 0 출력
						if (hashsetBox.size() != 9) {
							System.out.println("#" + tc + " " + 0);
							flag = false;
							break bigone;
						}
					}
				}
				// 한 번만 돌고 싶었는데, 나는 왜 while로밖에 생각이 안 날까
				break;
			} // end of while : 하나 틀리면 바로빼기 위함

			if (flag) { // flag가 참이라면 1로 뽑아
				System.out.println("#" + tc + " " + 1);
			}

		}

	}
}
