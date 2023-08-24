package BOJ_220716;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_AB_wrong {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] visited = new int[B + 1];
		Queue<Integer> que = new LinkedList<>();
		que.add(A);
		visited[A] = 1;
		boolean flag = false;
		outer: while (!que.isEmpty()) {
			int now = que.poll();
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					int addOne = now * 10 + 1;
					if (addOne > B || visited[addOne] > 0)
						continue;
					visited[addOne] = visited[now] + 1;
					que.add(addOne);
					if (addOne == B) {
						flag = true;
						break outer;
					}
				} else {
					int timesTwo = now * 2;
					if (timesTwo > B || visited[timesTwo] > 0)
						continue;
					visited[timesTwo] = visited[now] + 1;
					que.add(timesTwo);
					if (timesTwo == B) {
						flag = true;
						break outer;
					}

				}
			}

		} // end BFS
		if (flag) {
			System.out.println(visited[B]);
		} else {
			System.out.println(-1);
		}

	}
}
