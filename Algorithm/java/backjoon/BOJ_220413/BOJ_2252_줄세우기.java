package BOJ_220413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 간선 수

		List<Integer>[] arr = new ArrayList[N + 1]; // 배열 넣는 위치
		int[] inCnt = new int[N + 1]; // 진입차수 세는 배열

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		// 입력과, 진입차수, 간선연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			inCnt[end]++; // 진입차수증가
			arr[start].add(end); // 갈 수 있는거 증가

		}
		
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inCnt[i] == 0) {
				que.add(i);
			}
		} // 0 넣어줬어

		while (!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(" ");

			for (int togo : arr[now]) {
				inCnt[togo]--;
				if (inCnt[togo] == 0) {
					que.add(togo);

				}
			}
		}
		System.out.println(sb);

	}
}
