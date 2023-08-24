package aps_220414;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SWEA_5650_핀볼 {
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 }; // 0, 상, 하, 좌. 우
	static int[][] arr; // 이건 지도!
	static int ans; // 최대값 찾기
	static int cnt; // 현재 위치, 현재 방향으로 갔을 때 벽 || 블록에 부딫힌걸 카운트
	static int[] start;
	static HashMap<Integer, ArrayList<int[]>> warmholes;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = 0;
			arr = new int[N][N];
			warmholes = new HashMap<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] >= 6 && arr[i][j] <= 10) {
						if (warmholes.containsKey(arr[i][j])) {
							warmholes.get(arr[i][j]).add(new int[] { i, j });
						} else {
							warmholes.put(arr[i][j], new ArrayList<>());
							warmholes.get(arr[i][j]).add(new int[] { i, j });
						}

					}
				}
			} // 입력 완료

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (arr[i][j] == 0) {

						for (int d = 1; d <= 4; d++) {
							cnt = 0;
							go(i, j, d);
						}

					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // end testCase
	}

	private static void go(int r1, int c1, int direction) {
		// 일단 방문처리
		boolean flag = true;
		int r = r1;
		int c = c1;
		while (true) {
			// System.out.println("r : " + r1 + " c : " + c1 + " direction : " + direction +
			// " cnt : " + cnt);
			// 근데 들어왔는데 범위 밖? 다시 방향 바꿔서 원래자리로

			if (!intheMap(r1, c1)) {
				cnt++;
				int newd = changeDirection(direction, 0);
				r1 += dr[newd];
				c1 += dc[newd];
				direction = newd;
			}
			// 블랙홀이거나
			if (arr[r1][c1] == -1) {

				ans = Math.max(ans, cnt);
				return;
			}
			// 시적점으로 되돌아오면.

			if (r1 == r && c1 == c) {
				if (flag) {
					flag = false;
				} else {
					ans = Math.max(ans, cnt);
					return;
				}
				// System.out.println("r : " + r1 + " c : " + c1 + " direction : " + direction +
				// " cnt : " + cnt);

			}
			// 이제 웜홀을 만난다면.
			if (arr[r1][c1] >= 6) {

				int[] newhole = findOtherHole(r1, c1);
				r1 = newhole[0] + dr[direction];
				c1 = newhole[1] + dc[direction];

			} else if (arr[r1][c1] >= 1 && arr[r1][c1] <= 5) {
				// 1 더해주고 방향 바꿔주기
				cnt++;
				int newd = changeDirection(direction, arr[r1][c1]);
				r1 += dr[newd];
				c1 += dc[newd];
				direction = newd;

			} else if (arr[r1][c1] == 0) {
				r1 += dr[direction];
				c1 += dc[direction];
			}
		}

	}

	private static int changeDirection(int now, int triangle) {
		switch (now) {
		case 1: // 상
			if (triangle == 2) // 상 -> 우
				return 4;
			else if (triangle == 3) // 상 -> 좌
				return 3;
			else
				return 2; // 상->하

		case 2: // 하
			if (triangle == 1) // 하->우
				return 4;
			else if (triangle == 4) // 하 -> 좌
				return 3;
			else // 하 -> 상
				return 1;
		case 3: // 좌
			if (triangle == 1)
				return 1; // 좌 -> 상
			else if (triangle == 2)
				return 2; // 좌 -> 하
			else
				return 4; // 좌 -> 우
		case 4: // 우
			if (triangle == 3)
				return 2; // 우 -> 하
			else if (triangle == 4)
				return 1; // 우 -> 상
			else
				return 3; // 우 -> 하

		}
		return -1; // 없으면?

	}

	private static boolean intheMap(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return false;
		return true;
	}

	private static int[] findOtherHole(int r, int c) {
		int key = arr[r][c];
		int[] ans = new int[2];
		for (int[] a : warmholes.get(key)) {
			if (a[0] == r && a[1] == c) {
				continue;
			}
			ans[0] = a[0];
			ans[1] = a[1];
		}
		return ans;

	}

}
