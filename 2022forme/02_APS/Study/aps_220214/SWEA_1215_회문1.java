package aps_220214;

import java.util.Scanner;

public class SWEA_1215_회문1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = sc.nextInt();// 회문의 개수

			char[][] arr = new char[8][8]; // 입력받을 배열
			//
			int cnt = 0; // 정답

			String str; // 입력받을 문자
			// 입력 받기
			for (int i = 0; i < 8; i++) {
				str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 회문의 길이를 2로 나눈 몫 만큼만 비교하기 위한 forCount
			int forCount = n / 2;
			// 갯수 세기 위한 열,행 방향
			boolean flagCol;
			boolean flagRow;
			// 가로만 검사하기
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) { // 가로, 세로 길이인 8, 거기에 n만큼을 뺀 값만 돌아도 회문 검사 가능

					flagCol = true; // 열로보기(가로)
					flagRow = true; // 행으로 보기(세로)
					// 열로 보는 관점.
					for (int k = 0; k < forCount; k++) {
						// n칸짜리의 배열, 처음과 끝을 비교하기 시작해서 하나라도 아니면 false!
						if (arr[i][j + k] != arr[i][j + n - 1 - k]) {
							flagCol = false;
							break;
						}

					}
					// 행으로 보는 관점
					for (int k = 0; k < forCount; k++) {
						// n칸짜리의 배열, 처음과 끝을 비교하기 시작해서 하나라도 아니면 false!
						if (arr[j + k][i] != arr[j + n - 1 - k][i]) {
							flagRow = false;
							break;
						}

					}
					if (flagCol) {
						cnt += 1;
					}
					if (flagRow) {
						cnt += 1;
					}
				}
			} // end for : 가로 검사
			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
