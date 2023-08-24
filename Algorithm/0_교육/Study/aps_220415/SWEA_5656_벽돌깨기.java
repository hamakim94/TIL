package aps_220415;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {

	static int N, W, H; // 공개수, 너비(열개수), 깊이(행개수)
	// static int[][] arr;
	static int[] dr = { 0, 1, 0, -1 }; // 왼, 아래, 오
	static int[] dc = { -1, 0, 1, 0 }; // 왼, 아래, 오
	static int minBomb;

	static class Brick {
		int r;
		int c;
		int power;

		public Brick(int r, int c, int[][] arr) {
			this.r = r;
			this.c = c;
			this.power = arr[r][c];
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] newArr = new int[H][W];
			minBomb = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					newArr[i][j] = sc.nextInt();
				}
			}
			go(newArr, 0);
			System.out.println("#" + tc + " " + minBomb);

			// 하지말고, 모든 경우의 수 다 터트리면서, 해당 배열 가지고 내려가기!
//		int[][] temp = bomb(newArr, new boolean[H][W], 0);
//		temp = bomb(temp, new boolean[H][W], 0);
//		temp = bomb(temp, new boolean[H][W], 0);
//		System.out.println(countArr(temp));
			// 터트리고, 배열 아래로 내리기.
			// N - 필요한 개수 빼고, 남은 개수로 또 남은 공 개수만큼 돌면서 가장 많이 터지는거 확인
			// System.out.println(minBomb);
		}
	}

	// 이제, N의 개수만큼, 0~W-1까지 N개를 뽑는 경우의 수를 모두 구해야함

	static void go(int[][] arr, int cnt) {
		if (cnt == N) {
			if (minBomb > countArr(arr)) {
				minBomb = countArr(arr);
//				System.out.println("-----------------------");
//				for (int i = 0; i < H; i++) {
//					System.out.println(Arrays.toString(arr[i]));
//				}

			}
//			System.out.println(cnt);
			return;

		}
		int[][] temp = new int[H][W];

		for (int i = 0; i < W; i++) {

			deepCopy(arr, temp);
			temp = bomb(temp, new boolean[H][W], i);
			go(temp, cnt + 1);
		}
	}

	static void deepCopy(int[][] origin, int[][] copy) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}

	static int countArr(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 열고정, 행움직이기
	static int[][] pulldown(int[][] arr, int r, int c) {
		// 각 행별로 0있는지 확인
		for (int i = 0; i < c; i++) {
			for (int j = r - 1; j >= 0; j--) {
				if (arr[j][i] == 0) {
					// 0 만나면 계속 내리고, 바닥/>0이면 멈춰
					int temp = j;
					while (temp > 0) {
						if (arr[--temp][i] > 0) {
							// swap
							int k = arr[temp][i];
							arr[temp][i] = arr[j][i];
							arr[j][i] = k;
							break;
						}
					}

				}
			}
		}
		return arr;

	}

	// 해당 열을를 입력하면, 1 이상을 찾아매섭게 터트리는 함수.
	static int[][] bomb(int[][] arr, boolean[][] visited, int c) {
		boolean check = false;
		int r = 0;
		for (int tempr = 0; tempr < H; tempr++) {
			// System.out.println(arr[tempr][c]);
			if (arr[tempr][c] > 0) {
				check = true;
				r = tempr;
				break;

			}
		}

		if (check) {
			Queue<Brick> que = new LinkedList<>();

			visited[r][c] = true;
			que.add(new Brick(r, c, arr));
			while (!que.isEmpty()) {
				Brick now = que.poll();
				arr[now.r][now.c] = 0;
				// 여기서, now의 개수 - 1 만큼 for문을 돌면서 BFS 넣을거 찾자.
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < now.power; i++) {
						int newR = now.r + dr[k] * i;
						int newC = now.c + dc[k] * i;

						if (newR < 0 || newR >= H || newC < 0 || newC >= W || visited[newR][newC]
								|| arr[newR][newC] == 0)
							continue;
						que.add(new Brick(newR, newC, arr));
						visited[newR][newC] = true;

					}
				}

			}
			pulldown(arr, arr.length, arr[0].length);
//			for (int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			return arr;

		} else
			return arr;// 하지마

	}
}
