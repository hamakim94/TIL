package aps_220217;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {

	public static int N, L, maxHappiness; // N : 재료수, L : 칼로리의 최대치
	public static int[] delicious, calories; // 맛점수 , 칼로리 배열

	public static void main(String[] args) {

		// 입력 받기
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			// 입력받고
			N = sc.nextInt();
			L = sc.nextInt();
			// 배열만들고
			delicious = new int[N];
			calories = new int[N];

			// 배열 입력 받고
			for (int i = 0; i < N; i++) {
				delicious[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			// 최대 행복도 초기화
			maxHappiness = Integer.MIN_VALUE;

			// 함수 선언
			happyDiet(0, 0, 0);
			System.out.println("#" + tc + " " + maxHappiness);
		} // end for: 끝

	} // end main; 인덱스 맛점수 칼로리

	public static void happyDiet(int idx, int score, int cal) {
		// base
		// 만약 칼로리가 기존보다 높아!!! -> out!
		if (cal > L)
			return;
		// 끝까지 갔고, 칼로리가 L보다 작아? 그럼 최대;최소 비교해!! 그리고 끝!
		if (idx == N && cal < L) {
			maxHappiness = Math.max(maxHappiness, score);
			return;
		}
		// 위에서 안 걸리고, idx가 끝까지 이미 돌았다? 그냥 돌아가~
		if (idx == N) {
			return;
		}

		// recursion
		happyDiet(idx + 1, score, cal);
		happyDiet(idx + 1, score + delicious[idx], cal + calories[idx]);
	}
}