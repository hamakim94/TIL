package BOJ_220516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR_시간초과 {
	// 일단, 내가 어떤 처리를 했는지 담을 String과, d1,d2,d3,d4를 저장하는 걸 만들어볼까?
	static class DSLR {
		int num;
		String whatIdid; // 현재까지 어떤 처리를 했는지

		public DSLR(int num, String whatIdid) {
			this.num = num;
			this.whatIdid = whatIdid;
		}

	}

	static boolean[] visited; // 방문처리, 이미 갔던건 다시 하지마~
	static Queue<DSLR> que;
	static int start, ans;

	// 우선 함수 3개 만들거야
	// 1. d1, d2, d3, d4 각 자리수를 나타내는 함수 만들기
	// 그다음 4개
	// D, S, L, R 구현하기
	// 그 다음어떻게 할지 생각해보자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			ans = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			DSLR dslr = new DSLR(start, "");
			
			que = new LinkedList<>();
			que.add(dslr);
			while (true) {
				DSLR now = que.poll();
				int num = now.num;
				visited[num] = true;

				// D 처리
				DSLR dNext = D(now);
				if (dNext.num == ans) {
					System.out.println(dNext.whatIdid);
					break;
				} else if (!visited[dNext.num])
					que.add(dNext);

				// S처리
				DSLR sNext = S(now);
				if (sNext.num == ans) {
					System.out.println(sNext.whatIdid);
					break;
				} else if (!visited[sNext.num])
					que.add(sNext);

				DSLR lNext = L(now);
				if (lNext.num == ans) {
					System.out.println(lNext.whatIdid);
					break;
				} else if (!visited[lNext.num])
					que.add(lNext);

				DSLR rNext = R(now);
				if (rNext.num == ans) {
					System.out.println(rNext.whatIdid);
					break;
				} else if (!visited[rNext.num])
					que.add(rNext);
			} // end while : 탐색 끝
		}
	}

	private static DSLR R(DSLR dslr) {

		int num = dslr.num;
		int d4 = num % 10;
		num /= 10;
		int d3 = num % 10;
		num /= 10;
		int d2 = num % 10;
		int d1 = num / 10;

		int next = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
		String status = dslr.whatIdid + "R";
		DSLR k = new DSLR(next, status);
		return k;
	}

	private static DSLR L(DSLR dslr) {

		int num = dslr.num;
		int d4 = num % 10;
		num /= 10;
		int d3 = num % 10;
		num /= 10;
		int d2 = num % 10;
		int d1 = num / 10;

		int next = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
		String status = dslr.whatIdid + "L";
		DSLR k = new DSLR(next, status);
		return k;
	}

	private static DSLR S(DSLR dslr) {
		int num = dslr.num;

		String status = dslr.whatIdid + "S";
		int next = (num == 0) ? 9999 : num - 1;
		DSLR k = new DSLR(next, status);
		return k;
	}

	private static DSLR D(DSLR dslr) {
		int num = dslr.num;

		String status = dslr.whatIdid + "D";
		int next = (2 * num >= 10000) ? 2 * num % 10000 : 2 * num;
		DSLR k = new DSLR(next, status);
		return k;
	}

}
