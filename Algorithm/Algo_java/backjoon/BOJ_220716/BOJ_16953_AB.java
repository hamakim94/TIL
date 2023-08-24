package BOJ_220716;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16953_AB {
	static long A, B;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		System.out.println(bfs());
	}

	private static long bfs() {
		int cnt = 0;
		Queue<Long> q = new LinkedList<>();
		q.add(A);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long now = q.poll();
				if (now == B)
					return cnt + 1;
				if (now * 2 <= B)
					q.add(now * 2);
				if (now * 10 + 1 <= B)
					q.add(now * 10 + 1);

			}
			cnt++;
		}
		return -1;
	}
}
