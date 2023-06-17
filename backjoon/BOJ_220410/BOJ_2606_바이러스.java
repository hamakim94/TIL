package BOJ_220410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	// 그래프를 만들어볼까
	static int[][] graph; // 그래프
	static boolean[] visited; // 방문처리
	static int N; // 컴퓨터의 수
	static int test; // 연결돼있는 쌍 수
	static int ans;// 정답

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		test = Integer.parseInt(br.readLine());

		for (int i = 0; i < test; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = 1;
			graph[end][start] = 1;

		} // end for : 그래프 입력 완료
		visited[1] = true; // 방문처리
		find(1);
		System.out.println(ans);
	}

	private static void find(int idx) {
		for (int i = 1; i <= N; i++) {
			if (graph[idx][i] == 0 || visited[i]) continue;
			
			visited[i] = true; // 방문처리
			ans++; // 1번을 통해 라고 나와있으니, 1번은 숫자 제외
			find(i);
		}
	}

}
