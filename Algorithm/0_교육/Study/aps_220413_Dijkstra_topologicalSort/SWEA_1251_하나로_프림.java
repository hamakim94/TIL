package aps_220413;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로_프림 {
	static int N; // 섬의 개수

	static int[] X, Y;
	static double E; // 세율
	static double ans; // 정답
	static double[][] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = new int[N]; // x좌표모음
			Y = new int[N]; // y좌표모음

			ans = 0;
			adj = new double[N][N]; // 인접 행렬 만들기

			for (int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Y[i] = sc.nextInt();
			}

			E = sc.nextDouble();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double cost = distance(X[i], X[j], Y[i], Y[j]);
					adj[j][i] = cost; // 무향이니까
					adj[i][j] = cost;
				}
			}
			boolean[] visited = new boolean[N]; // 박문철이
			double[] dist = new double[N];
			Arrays.fill(dist, Double.MAX_VALUE);
			
			// 0번 시작!
			dist[0] = 0;
			
			for(int i=0; i<N-1; i++) {
				double min = Double.MAX_VALUE;
				int idx = -1;
				for(int j=0; j<N; j++) {
					if(!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				visited[idx] = true;
				for(int j=0; j<N; j++) {
					if(!visited[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
						dist[j] = adj[idx][j];
					}
				}
			}
			for(int i=0; i<N; i++) {
				ans += dist[i];
			}
			System.out.println("#" + tc + " " + Math.round(ans));

		} // tc
	}

	static double distance(int x1, int x2, int y1, int y2) {
		// 두 개의 좌표를 이용해 가중치를 구함
		return (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) * E;
	}
}
