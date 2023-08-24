package aps_220411_graph;

import java.util.Arrays;
import java.util.Scanner;

public class 그래프05_프림 {

	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 갯수인데 0부터 들어온다
		int E = sc.nextInt(); // 간선의 개수

		// 인접 행렬
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			// 대입연산자는 오른쪽부터 ㄱㄱ
			adjArr[st][ed] = adjArr[ed][st] = w;
		}
		// 박문철이
		boolean[] visited = new boolean[V];// 박문철2
		int[] dist = new int[V]; // key라고 불린 친구
		int[] p = new int[V]; // 나의 근본

		// dist라는 배열에 임의의 큰 값
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 시작 정점은 보통 0으로 둔다
		dist[0] = 0;
		p[0] = -1;

		int min, idx, ans = 0; // 최소값, 최소값 인덱스, 비용이총합
		for (int i = 0; i < V- 1; i++) {
			min = Integer.MAX_VALUE;
			idx = -1;
			// 아직 안 고른 친구들 중에서 제일 거리가 작은 값을 뽑아보자..
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			visited[idx] = true; // 제일 작은값을 가지고 있는 친구 쳌..
			for (int j = 0; j < V; j++) {
				// 방문하지 않았고 간선이 있고 기존에 넣었던 값과 바뀌면
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					p[j] = idx;
					dist[j] = adjArr[idx][j];
				}
			}

		}
		
		for(int i=0; i<V; i++) {
			ans += dist[i];
		}
		System.out.println(ans);

	} // main

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
}
