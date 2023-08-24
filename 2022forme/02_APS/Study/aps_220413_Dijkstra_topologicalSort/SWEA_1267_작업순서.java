package aps_220413;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_작업순서 {

	static int V, E; // 정점의 수 , 간선의 수
	static List<Integer>[] arr; // 연결 리스트
	static int[] inCnt; // 개수 셀 배열
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			arr = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			inCnt = new int[V + 1];

			// 해야할 거
			// 연결상태 배열속 어레이리스트 만들기
			// 똑같은 배열 만들어서, 사이즈 담기(몇개 연결됐니)
			for (int i = 1; i <= V; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				inCnt[end]++; // 각 정점별 진입차수 표시
				arr[start].add(end); // 가는곳 표시

			}
			topologicalSort(tc);

			// 반복문 돌기

			// 2. 하나 빼고, 주변 가서, 1씩 감소(만약 0 나오면 que에 에드)
			// 끝.
		} // end testCase
		System.out.println(sb);

	}

	private static void topologicalSort(int tc) {
		sb.append("#").append(tc).append(" ");
		Queue<Integer> que = new LinkedList<>();
		// 1. 0이면 넣고
		for (int i = 1; i <= V; i++) {
			if (inCnt[i] == 0) {
				que.add(i);
				visited[i] = true;
				sb.append(i).append(" ");
			}
		}
		while (!que.isEmpty()) {
			// 하나 빼서
			int idx = que.poll();
			// 갈수 있는곳 돌면서 1씩 뺴줘
			for (int togo : arr[idx]) {
				if (!visited[togo]) {
					inCnt[togo]--;
					// 0이 되면 박문철이, que에 더해주기
					if (inCnt[togo] == 0) {
						visited[togo] = true;
						que.add(togo);
						sb.append(togo).append(" ");
					}
				}

			}

		}
		sb.append("\n");

	}
}
