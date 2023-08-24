package aps_220414;

import java.util.Scanner;

public class SWEA_4012_요리사 {

	static int N, R; // 배열의 크기 // 반으로 나눠질 크기
	static int[][] synergy; // 시너지 저장할 배열
	static int data[]; // 인덱스들 조합할 원래배열
	static int sel[]; // N/2로 나눌 배열 하나
	static int sel2left[], sel2right[]; // 상호배타집합
	static int selOther[]; // N/2로 나눠지면, 나머지 인덱스들 채울 배열
	static int ans, sum1, sum2; // 두 시너지의 차이를 계산하기 위한 값.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			// 입력 받기 완료
			N = sc.nextInt();
			R = N / 2;
			synergy = new int[N][N];
			data = new int[N];
			sel = new int[N / 2];
			selOther = new int[N / 2];
			sel2left = new int[2];
			sel2right = new int[2];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				data[i] = i;
				for (int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
		// 총 2가지 함수가 필요하다, N C N/2 한거랑., 나머지 배열들 가지고 2개 조합해서 시너지 더하는 함수

	}

	static void comb(int idx, int sidx) {
		if (sidx == R) {
			// 이제, sel과 반대인 집합도 뽑아야하는데..
			// idx로 접근하고 싶은데. N크기의 배열 만들어서 sel 안에 있는건 true로..
			boolean[] arr = new boolean[N];
			for (int t : sel) {
				arr[t] = true;
			}
			// 나머지 배열 만들기 위한 변수 설정, false면 그 배열에 넣으렴
			int otherIdx = 0;
			for (int t = 0; t < N; t++) {
				if (arr[t] == false)
					selOther[otherIdx++] = t;
			} // 만들어 졌고
			sum1 = 0;
			sum2 = 0;
			calcComb2(0, 0, sel, selOther);
			//System.out.println("sum1 :" + sum1 + " sum2 : " + sum2);
			ans = Math.min(ans, Math.abs(sum1 - sum2));
			return;

		}
		// 조합 돌기, N C (N/2)
		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = data[i];
			comb(i + 1, sidx + 1);
		}

	}

	private static void calcComb2(int idx, int sidx, int[] sel3, int[] sel4) {
		// (N/2) C 2
		// R -- 2인 경우다
		if (sidx == 2) {
			// 왼쪽 변수에 시너지 챙기고, 오른쪽 변수에도 시너지 챙겨
			sum1 += synergy[sel2left[0]][sel2left[1]];
			sum1 += synergy[sel2left[1]][sel2left[0]];
			sum2 += synergy[sel2right[0]][sel2right[1]];
			sum2 += synergy[sel2right[1]][sel2right[0]];
			return;
		}
		// 조합 돌아~
		for (int i = idx; i <= (N / 2) - 2 + sidx; i++) {
			sel2left[sidx] = sel3[i];
			sel2right[sidx] = sel4[i];
			calcComb2(i + 1, sidx + 1, sel3, sel4);
		}

	}

}
