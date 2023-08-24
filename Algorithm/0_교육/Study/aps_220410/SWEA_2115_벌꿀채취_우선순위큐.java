package aps_220410;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_2115_벌꿀채취_우선순위큐 {

	// 허니 클래스 : 최대 이익과, 현재 있는 행과 열을 가지고 있어
	static class Honey implements Comparable<Honey> {
		int profit;
		int r;
		int c;

		public Honey(int profit, int r, int c) {
			super();
			this.profit = profit;
			this.r = r;
			this.c = c;
		}

		public int compareTo(Honey o) {
			// TODO Auto-generated method stub
			return o.profit - this.profit;
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
	static int[] temp; // 임시 벌통
	static int maxVal; // 최대값

	static PriorityQueue<Honey> que;

	public static void main(String[] args) {
		// 입력 받기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			arr = new int[N][N];
			que = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();

				}
			} // 입력 완료
				// 계획 : for문을 돌면서 해당 좌표값에서 얻을 수 있는 최대 이익을 구함(부분집합)

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					// 임시 벌통 생성
					temp = new int[M];
					maxVal = 0;
					for (int t = 0; t < M; t++) {
						temp[t] = arr[i][j + t];
					}
					// 재귀 돌려서 샤라락
					harvest(0, 0, 0);
					que.add(new Honey(maxVal, i,j));
				}
			}

			Honey first = que.poll();
			Honey second;
			while (true) {
				second = que.poll();
				if (first.r == second.r && first.c + M >= second.c && first.c - M <= second.c) {

				} else {
					break;
				}
			}
			System.out.println("#" + tc + " " + (first.profit + second.profit));

		} // end testCase

	} // end main

	private static void harvest(int idx, int sumHoney, int sumMoney) {
		// base case
		if (sumHoney > C)
			return;
		
		maxVal = Math.max(sumMoney,  maxVal);
		
		for(int i = idx; i < M; i++) {
			harvest(i + 1, sumHoney + temp[i], sumMoney + temp[i]*temp[i]);
		}

	}

}
