package BOJ_220516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	// 일단, 내가 어떤 처리를 했는지 담을 String과, d1,d2,d3,d4를 저장하는 걸 만들어볼까?
	static class DSLR {
		int num; // 현재 내 숫자!
		String status; // 현재까지 어떤 처리를 했는지

		public DSLR(int num, String status) {
			this.num = num;
			this.status = status;
		}

	}

	static boolean[] visited; // 방문처리, 이미 갔던건 다시 하지마~
	static Queue<DSLR> que; // BFS 도는 느낌
	static int start, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			ans = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			// 입력받기 끝
			DSLR dslr = new DSLR(start, ""); // 일단 하나 만들고
			que = new LinkedList<>(); // que 만들어서
			que.add(dslr); // 하나 넣어
			visited[start] = true; // 여기서 방문처리 개념 헷갈려서 엄청 틀림..
			while (!que.isEmpty()) {
				DSLR now = que.poll();
				int num = now.num;
				String status = now.status;
				// 하나 꺼내고 확인하는거니까, 앞으로 갈 좌표 방문처리 해야겠네!
				if (num == ans) {
					System.out.println(now.status);
					break;
				}

				// D 처리 : 삼항연산자를 통해 조건을 넣음
				int next = (2 * num >= 10000) ? 2 * num % 10000 : 2 * num;
				if (!visited[next]) { // 방문하지 않았다면
					visited[next] = true; // 한 번 체크했던 곳이란다.
					que.add(new DSLR(next, status + "D")); // 그리고 나서 넣으니까 돌긴 돌잖아!
				}

				// S처리
				next = (num == 0) ? 9999 : num - 1;
				if (!visited[next]) {
					visited[next] = true;
					que.add(new DSLR(next, status + "S"));
				}
				// 자릿수옮기기
				int d4 = num % 10;
				num /= 10;
				int d3 = num % 10;
				num /= 10;
				int d2 = num % 10;
				int d1 = num / 10;
				// 좌측으로! 예시에 나온 수 그대로 쓰기로 함
				next = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
				if (!visited[next]) {
					visited[next] = true;
					que.add(new DSLR(next, status + "L"));
				}
				// 우측으로, 마찬가지
				next = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;

				if (!visited[next]) {
					visited[next] = true;
					que.add(new DSLR(next, status + "R"));
				}
			} // end while : 탐색 끝
		}
	}

}
