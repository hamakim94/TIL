package aps_220412;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {

	static int maxNum; // 들고다니는 최대값 사람
	static int maxDepth; // 들고다니는 최대깊이 : 크거나 같을 때 최소값 비교
	static int[][] arr; // 101*101사이즈 배열
	static int[] visited;
	static int N, start; // 자료의 수 / 시작점
	static Queue<Integer> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {
			maxDepth = 0;
			maxNum = 0;
			arr = new int[101][101];
			visited = new int[101];
			que = new LinkedList<Integer>();
			N = sc.nextInt();
			start = sc.nextInt();
			// 자료 입력
			for (int i = 0; i < N / 2; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				arr[l][r] = 1;
			}
			BFS(start);
			// 구한 최대 깊이와, visited의 최대 깊이가 같을 때, 사람 최대값 찾기
			for (int i = 1; i <= 100; i++) {
				if (visited[i] == maxDepth) {
					maxNum = Math.max(i, maxNum);
				}
			}
			sb.append("#").append(tc).append(" ");
			sb.append(maxNum).append("\n");
		} // end testCase
		System.out.println(sb);

	}

	private static void BFS(int start) {
		// 박문철이 : 1 이상이면 방문한거
		visited[start] = 1;
		que.add(start);

		while (!que.isEmpty()) {
			// 하나 뽑고
			int now = que.poll();
			int t = visited[now]; // 현재 몇 번째 넓이에 깊이에 있는지
			for (int i = 1; i < 101; i++) {
				if (arr[now][i] == 0 || visited[i] >= 1) // 못 가거나, 간적 있으면 가지마!
					continue;
				que.add(i); // 앞으로 갈 수 있는 경우 다 더해줌
				visited[i] = t + 1; // 내가 간 깊이 + 1씩 해줘서 저장
				maxDepth = Math.max(t + 1, maxDepth); // 최대 길이 저장
			}

		}

	}

}
