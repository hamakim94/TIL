package aps_220410;

import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {

	// 허니 클래스 : 최대 이익과, 현재 있는 행과 열을 가지고 있어
	static class Honey {
		int profit;
		int r;
		int c;

		public Honey(int profit, int r, int c) {
			super();
			this.profit = profit;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Honey [profit=" + profit + ", r=" + r + ", c=" + c + "]";
		}
		
	}

	// 이렇게 밖에 기준을 두면 조금 편해짐
	static Honey first; // 가장 이익이 많이 남
	static Honey second; // 두번째로 가장 이익이 많이 남
	static int N, M, C; // 벌통의 크기, 벌통의 개수, 최대 꿀의 양
	static int arr[][]; // 벌통

	public static void main(String[] args) {
		// 입력 받기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();

				}
			} // 입력 완료
				// 계획 : for문을 돌면서 해당 좌표값에서 얻을 수 있는 최대 이익을 구함(부분집합)

			first = new Honey(0, 0, 0);
			second = new Honey(0, 0, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					profit(i, j);
				}
			}
			System.out.println(first.toString());
			System.out.println(second.toString());
			System.out.println("#" + tc + " " + (first.profit + second.profit));

		} // end testCase

	} // end main

	private static void profit(int r, int c) {
		// 계획 : for문을 돌면서 해당 좌표값에서 얻을 수 있는 최대 이익을 구함(부분집합)
		// 최대 이익 찾기
		int[] temp = new int[M];
		// 부분집합을 위한 임시 배열 생성
		for (int i = 0; i < M; i++) {
			temp[i] = arr[r][c + i];
		}
		// 비트마스킹을 활용한 최대값 구하기
		int maxMoney = 0; // 모든 부분집합을 돌고 최대값을 구하기 위함

		for (int i = 1; i < (1 << M); i++) {
			int sumHoney = 0; // C랑 비교하기 위한 꿀 최대
			int sumMoney = 0; // 돈을 넣기 위함
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) != 0) {
					sumHoney += temp[j];
					sumMoney += temp[j] * temp[j];
				}
				if (sumHoney > C)
					continue;
				maxMoney = Math.max(maxMoney, sumMoney);
			}

		} // 모든 경우의 수를 돌면서 최대 이익 구함
		// 0,1, 0,4
		// 1. 현재 이익 > first 이익
		if (maxMoney > first.profit) {
			// 1-1. 현재 first랑 겹친다면, first만 바꿔'
			// r.c, 현재 보고있는 row와 column;
			// first.r : 
			if (first.r == r && c < first.c + M  && first.c - c >M) {
				Honey honey = new Honey(maxMoney, r, c);
				first = honey;
			}
			// 1-2. 현재 first랑 겹치지 않는다면, second를 first로 바꾸고 first에 새로 만들어서 넣어
			else {
				second = first;
				Honey honey = new Honey(maxMoney, r, c);
				first = honey;

			}
			// 2. 현재 이익 > second 이익
		} else if (maxMoney > second.profit) {
			// 2-1. 현재 칸이 first랑 겹치면, 아무것도 하지 않는다.
			if (first.r == r && c < first.c + M) {

				// 2-2. 현재 이익이 first랑 겹치지 않는다면, senond 교체
			} else {
				Honey honey = new Honey(maxMoney, r, c);
				second = honey;
			}

		}

	}
}
