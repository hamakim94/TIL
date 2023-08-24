package aps_220408;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_보호필름_자바 {
	static int D, W, K; // 행(두께), 열, K(통과기준)
	static int[][] film; // 필름 저장할 친구
	static int ans; // 정답
	static int[] A ,B; // 주소!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();

			film = new int[D][W];
			A = new int[W]; // 0으로 차있음
			B = new int[W];
			Arrays.fill(B, 1);
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // 입력 완료

			ans = 987654321; // 정답 초기화
			wkdgksrjf(0,0);
			System.out.println("#" + tc + " " + ans);
		}
	} // end main

	// 약품을 주입도 해보고, 그냥도 내려보는 재귀함수
	static void wkdgksrjf(int idx, int cnt) {
		// base
		if (check()) {
			if (ans > cnt) {
				ans = cnt;
				return;
			}
		}
		if(ans < cnt) return;
		
		if(idx == D)
			return;

		// recursive
		// 이거 얕은복사 int[] temp = film[idx];
		int[] temp = film[idx];
		
		// 약품 주입 X
		wkdgksrjf(idx + 1, cnt);
		// A약품 주입
		film[idx] = A;
		wkdgksrjf(idx + 1, cnt + 1);
		// B약품 주입
		film[idx] = B;
		wkdgksrjf(idx + 1, cnt + 1);
		film[idx] = temp;

	}

	static boolean check() {
		// 이제 각 열을 돌면서, 하나씩 체크

		for (int c = 0; c < W; c++) {
			boolean ans = false;
			// 내 이전의 행과 비교를 할 거니까 1부터 시작하겠다. => 틀린부분.
			int cnt = 1;
			for (int i = 1; i < D; i++) {
				if (film[i][c] == film[i - 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt == K) {
					ans = true;
					break;
				}

			} // 열들 다 돌았음
			if (!ans) {
				return false;
			}
		} // 열들 다 돌았음
		return true;
	}

}
