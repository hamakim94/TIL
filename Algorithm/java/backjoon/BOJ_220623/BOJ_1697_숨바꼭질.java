package BOJ_220623;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int start, end;
	static int[] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[100001];
		start = sc.nextInt();
		end = sc.nextInt();
		BFS();

	}

	private static void BFS() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		map[start] = 1;
		while (!que.isEmpty()) {
			int now = que.poll();

			for (int i = 0; i < 3; i++) {
				int to;
				if (i == 0) {
					to = now + 1;
				} else if (i == 1) {
					to = now - 1;
				} else {
					to = now * 2;
				}

				if (to == end) {
					System.out.println(map[now]);
					return;
				}

				if (to < 0 || to > 100000 || map[to] > 0)
					continue;
				map[to] = map[now] + 1;
				que.add(to);

			}

		}
	}
}
