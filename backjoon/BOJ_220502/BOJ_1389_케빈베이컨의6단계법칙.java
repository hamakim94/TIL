package BOJ_220502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {

	static int N, M; // 유저의 수, 친구 관계의 수
	static int[][] arr; // 친구 관계 행렬
	static int[] dist; // 최소 거리 구하는 행렬
	static boolean[] visited; // 방문 처리용
	static final int MAX = Integer.MAX_VALUE; // 초기값용

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> ansList = new ArrayList<>(); // 정답 sorting할 배열

		arr = new int[N + 1][N + 1];
		// 인접 행렬 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}

		for (int start = 1; start <= N; start++) {
			// 초기값은 최대값으로 해야지!
			dist = new int[N + 1];
			visited = new boolean[N + 1];
			Arrays.fill(dist, MAX);
			// 처음 시작점은 0으로 두고
			dist[start] = 0;

			for (int k = 0; k < N; k++) {
				// 처음 시작점 기준으로 최솟값을 찾아야해!
				int minIdx = -1;
				int minVal = MAX;
				for (int i = 1; i <= N; i++) { // 최소값 찾기
					if (!visited[i] && minVal > dist[i]) {
						minVal = dist[i];
						minIdx = i;
					}
				} // end for : 최소 idx 찾음
				
				visited[minIdx] = true; // 이제 방문 했어!
				// 여기서부터, 시작점에서 갈 수 있는거 다 가면서, 최소값으로 최신화 해야해!
				// 방문하지 않았고, 연결돼있고, 최신화 가능하다면~
				for (int end = 1; end <= N; end++) {
					if (!visited[end] && arr[minIdx][end] > 0 && arr[minIdx][end] + dist[minIdx] < dist[end]) {
						dist[end] = arr[minIdx][end] + dist[minIdx];
					}
				}
			} // end for : end 다익스트라
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += dist[i];
			}
			ansList.add(new int[] { start, sum });
		} // end for : 전체 넣기 완료
		ansList.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] == o2[1]) {
					return o1[0] - o2[0]; // 다익스 값이 같은 경우는, 시작지점 기준으로 오름차순!
				}
				// 다익스 값을 기준으로 오름차순!
				return o1[1] - o2[1];

			}
		});
		System.out.println(ansList.get(0)[0]);

	}
}
