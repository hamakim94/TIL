package aps_220407;

import java.util.Scanner;

public class SWEA_1486_보호필름_static {

	static int D, W, K; // D : 두께(3<=D<=13), W:가로크기(1<=W<=20), K:합격기준(1<=K<=D)
	static int minVal; // 최소바꿈횟수
	static int[][] film;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			D = sc.nextInt();// 두께(높이)
			W = sc.nextInt(); // 가로크기.
			K = sc.nextInt(); // 합격기준, 높이방향(세로) 연속 ..

			// 입력 완료
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // end input

			minVal = Integer.MAX_VALUE;
			change(0, 0);
			sb.append("#").append(tc).append(" ").append(minVal).append("\n");

		} // end testCase
		System.out.println(sb);
	} // end main

	// idx번째 행에서 3가지 경우로 나뉨 -> 안 바꾸거나, 0으로 바꾸기, 1로 바꾸기.
	// 0, 1으로 바꾼 경우는 1번 바꾼거므로, cnt라는 변수에 1 더해주기
	// 안 넣은 경우는 안 바꾼거니까 그대로 cnt 넘어가기.
	// 그냥 넣기
	// idx번째 행 0으로 바꾸고 재귀
	// idx번째 행 1로 바꾸고 재귀
	// 되돌리기.(여기서, 배열을 새로 만들고 복사해야지, 원래 값 다시 넣어줄 수 있음)
	static void change(int idx, int cnt) {
		// 가지치기, idx는 깊인데, 이게 구해놓은 최소값보다 크면 응 다시가~
		if (cnt >= minVal) {
			return;
		}

		// 체크가 잘 됐으면, 몇번 넣었는지 최소개수 세주렴, 그리고 더 안 해봐도 된단다
		if (checkOk()) {
			minVal = Math.min(minVal, cnt);
			return;
		}

		// 끝까지 왔음? 돌아가~
		if (idx == D) {
			return;
		}

		// idx번째 행을 복사해서 다니자!
		int[] now = new int[W];
		for (int w = 0; w < W; w++) {
			now[w] = film[idx][w];
		}
		change(idx + 1, cnt); // 안 바꾸고 그냥 넣기
		// idx행 0으로 바꿔주기
		for (int w = 0; w < W; w++) {
			film[idx][w] = 0;
		}
		// 재귀 돌리기(바꿨으니 개수 + 1)
		change(idx + 1, cnt + 1);
		// 나왔으면 idx행 1로 바꾸기
		for (int w = 0; w < W; w++) {
			film[idx][w] = 1;
		}
		// 재귀 돌리기(바꿨으니 개수 + 1)
		change(idx + 1, cnt + 1);

		// 다 나왔으면 원래 now값 돌려주기.
		film[idx] = now;

	}

	// 주어진 배열이 시험에통과할 수 있는지, 없는지 체크하는 함수
	static boolean checkOk() {
		// 가능하다고 가정하고, 아닌 경우에 바로 빽!

		// 가로만큼 돌면서,
		for (int w = 0; w < W; w++) {
			// 열의 기본 값을 false라 가정하고
			boolean flag = false;
			// 이전것과 같으면 1씩 추가해나갈 값
			int num = 1;
			for (int d = 1; d < D; d++) {
				// 직전 값과 비교
				if (film[d - 1][w] == film[d][w]) {
					num++;
				} else {
					num = 1; // 초기화
				}

				if (num == K) {
					flag = true;
					break;// 이번 열 나가
				}

			} // end for : 열 탐색 완료

			if (!flag) {
				return false; // 하나라도 통과하지 못하면 끝!
			}

		} // end w : 끝까지 완료
			// 그냥 다했어?
		return true;

	}
}
