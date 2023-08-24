package BOJ_220605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		st = new StringTokenizer(br.readLine());
		int idx = Integer.parseInt(st.nextToken()); // 시작점
		StringBuilder sb = new StringBuilder();
		ArrayList<int[]>[] arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		// 일단 인접 행렬로 해보자
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 간선의 수
			int v = Integer.parseInt(st.nextToken()); // 간선의 수
			int w = Integer.parseInt(st.nextToken()); // 간선의 수
			arr[u].add(new int[] { v, w });
		} // end for : 입력 완료

		int[] weight = new int[N + 1]; // 가중치 저장할 배열
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[idx] = 0;

//		for(int i=0; i<=N; i++) {
//			System.out.print(i + " : ");
//			for(int j=0; j<arr[i].size(); j++) {
//				System.out.print(Arrays.toString(arr[i].get(j)) + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < N - 1; i++) {
			// 방문하지 않은 것 중에 가장 작은 값 찾기
			int minVal = Integer.MAX_VALUE;
			int startIdx = -1;
			for (int j = 1; j <= N; j++) {
				if (minVal > weight[j] && !visited[j]) {
					minVal = weight[j];
					startIdx = j;
				}
			}
			visited[startIdx] = true;
			// 현재 내 위치에서 갈 수 있을 때, weight 배열 최신화하기
			for (int j = 0; j < arr[startIdx].size(); j++) {
				if (!visited[arr[startIdx].get(j)[0]]
						&& weight[arr[startIdx].get(j)[0]] > weight[startIdx] + arr[startIdx].get(j)[1]) {
					weight[arr[startIdx].get(j)[0]] = weight[startIdx] + arr[startIdx].get(j)[1];
				}
			}

		} // end 다익
		for (int i = 1; i <= N; i++) {
			if (i == idx) {
				sb.append(0).append('\n');
			} else {
				if (weight[i] == Integer.MAX_VALUE) {
					sb.append("INF").append('\n');
				} else {
					sb.append(weight[i]).append('\n');
				}
			}
		}
		System.out.println(sb);

	}
}
