package aps_220406;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1247_최적경로 {

	static int N, minDist;// N : 방문해야할 집 수 , 최소거리
	static int[] company; // 회사
	static int[] home; // 집
	static int[][] customers; // 고객의 좌표
	
	static boolean[] visited;
	static int[] arr; // 순열

	// 1~N까지 순열 만들고 싶어
	static int[] nums;

	// dfs로 짤래
	public static void main(String[] args) {

		// 입력 받기
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {

			N = sc.nextInt();

			company = new int[] { sc.nextInt(), sc.nextInt() };
			home = new int[] { sc.nextInt(), sc.nextInt() };
			customers = new int[N + 2][];
			customers[0] = company;
			nums = new int[N];
			for (int i = 1; i <= N; i++) {
				customers[i] = new int[] { sc.nextInt(), sc.nextInt() };
				nums[i - 1] = i;
			}
			customers[N + 1] = home;
			visited = new boolean[N];
			arr = new int[N];
			minDist = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + minDist);
		} // end testCases
	} // end main

	static void perm(int idx) {
		if (idx == N) {
			int start = dist(0, arr[0]);
			for(int i=1; i<N; i++) {
				start += dist(arr[i-1],arr[i]);
			}
			start += dist(N+1, arr[N-1]);
			minDist = Math.min(minDist, start);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			arr[idx] = nums[i];
			visited[i] = true;
			
			perm(idx + 1);
			visited[i] = false;

		}

	}

	static int dist(int i, int j) {
		int rdist = Math.abs(customers[i][0] - customers[j][0]);
		int cdist = Math.abs(customers[i][1] - customers[j][1]);
		return rdist + cdist;
	}

}
