package BOJ_220316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < testCase; tc++) {
			// 우선 큐 만들고
			LinkedList<int[]> que = new LinkedList<>();
			// que의 사이즈
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			// 내가 원하는 수!
			int idx = Integer.parseInt(st.nextToken());

			// 뽑을 때 마다, 1씩 더해줄 수
			int cnt = 0;

			// (중요도, 원하는 수)인지 까지 나옴,
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				que.add(new int[] { Integer.parseInt(st.nextToken()), i });
			}

			while (!que.isEmpty()) {
				// 최대값인지 판별하는 변수
				boolean isMax = true;
				// 일단 하나 뽑기
				int[] now = que.poll();
				// for문을 돌면서, 큰게 하나라도 있으면 isMax는 False
				for (int i = 0; i < que.size(); i++) {
					if (now[0] < que.get(i)[0]) {
						isMax = false;
						break;
					}
				}
				// 만약 최대라면
				if (isMax) {
					// 다시 안 넣고, cnt + 1 해준다(뽑았으니까)
					cnt++;
					// 근데 뽑은거 위치가 처음 설정한 idx라면
					if (now[1] == idx) {
						// 끝
						break;
					}
				// 아님 다시 더해줘
				} else {
					que.add(now);
				}

			}

			// 뽑아
			sb.append(cnt).append("\n");

		} // end for :
		System.out.println(sb);
	}

}
