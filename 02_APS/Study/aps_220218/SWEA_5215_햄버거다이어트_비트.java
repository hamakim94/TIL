package aps_220218;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트_비트 {

	public static int N, L; // N : 재료수, L: 칼롤리
	public static int[] score, calorie; // 점수 배열, 칼로리 배열
	public static int ans; // 점수 배열, 칼로리 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			ans = 0;
			score = new int[N];
			calorie = new int[N];

			// 점수와 칼로리 순으로 입력이 와

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			// 비트 연산
			for (int i = 0; i < (1 << N); i++) {
				// i는 하나의 부분집합
				int sumScore = 0; // 최종
				int sumCal = 0; // 하나하나

				// 일종에 자릿수 검사하는 느낌?0001, 0010, 0100, 1000
				for (int j = 0; j < N; j++) {
					// 해당 조건문이 참이면, j번째 재료가 들어있다는 것
					if ((i & (1 << j)) > 0) {
						sumScore += score[j];
						sumCal += calorie[j];

					}
				}
				if (sumCal <= L) {
					ans = Math.max(ans, sumScore);
				}
			}
			System.out.println("#" + tc + " " + ans);

		}

	}
}
