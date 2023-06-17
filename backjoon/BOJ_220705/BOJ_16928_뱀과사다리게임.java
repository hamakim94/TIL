package BOJ_220705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
	static int[] map = new int[101];
	static int[] snakeAndLadder = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			snakeAndLadder[start] = end;
		}
		Queue<Integer> que = new LinkedList<>();
		visited[1] = true;
		que.add(1);
		while (!que.isEmpty()) {
			int now = que.poll();
			if (now == 100) {
				System.out.println(map[100]);
				break;
			}
			for (int i = 1; i <= 6; i++) {
				int curr = now + i;
				if (curr > 100)
					continue;
				if (visited[curr])
					continue;
				if (snakeAndLadder[curr] != 0) {
					if (!visited[snakeAndLadder[curr]]) {
						visited[snakeAndLadder[curr]] = true;
						que.add(snakeAndLadder[curr]);
						map[snakeAndLadder[curr]] = map[now] + 1;
					}
				} else {
					que.add(curr);
					map[curr] = map[now] + 1;
					visited[curr] = true;
				}

			}
		}

	}
}
