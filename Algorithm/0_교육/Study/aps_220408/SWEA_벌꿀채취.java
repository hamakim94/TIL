package aps_220408;

import java.util.Scanner;

public class SWEA_벌꿀채취 {

	// 비용, 행, 열의 위치를 나타낼 수 있는 클래스 생성
	static class Honey {
		int cost, r, c;

		public Honey(int cost, int r, int c) {
			super();
			this.cost = cost;
			this.r = r;
			this.c = c;
		}

	}

	static int N, M, C; // 벌집의 가로크기, 벌통 개수, 최대 값
	static int[][] arr; // 벌집담기
	static Honey first, second; // 최고, 그 다음 honey

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 입력

			first = new Honey(0, 0, 0);
			second = new Honey(0, 0, 0);

			// 벌통을 뽑아보자
			for (int i = 0; i < N; i++) {
				// 열의 채취 범위를 잘 생각을 해보자
				for (int j = 0; j < N - M + 1; j++) {
					harvest(i, j);
				}
			}

		}
	}

	private static void harvest(int r, int c) {

		int maxCost = 0; // 이번 차례에 벌통에 구한 최대값

		int[] tmp = new int[M];
		for (int i = 0; i < M; i++) {
			tmp[i] = arr[r][c + i];
		}

		// powerset
		for (int i = 1; i < (1 << M); i++) {
			int sumHoney = 0;
			int sumCost = 0;

			for (int j = 0; j < M; j++) {
				if ((i & 1 << j) != 0) {
					sumHoney += tmp[j];
					sumCost += tmp[j] * tmp[j];

				}
			}
			if (sumHoney <= C)
				maxCost = Math.max(sumCost, maxCost);

		} // 이번 벌통의 최고의 값을 뽑아냈어
		
		if(maxCost < first.cost) {
			// 겹치는 경우 => 여기서 2가지 경우로 나뉘는건 first를 바꾸는 경우가 있기 때문에 2번
			if(r == first.r && c < first.c + M)
				first = new Honey(maxCost, r, c);
			// 안겹치는 경우
			second = first;
			first = new Honey(maxCost, r, c);
		} else if(maxCost > second.cost) {
			// 행이 다르거나 열이 겹치지 않는다면 : second랑 비교하는게 아니라 first랑 비교해야해
			// 겹치면 안 되니까
			if(r != first.r || c >= first.c + M)
				second = new Honey(maxCost, r, c);
			
		}

	}

}
