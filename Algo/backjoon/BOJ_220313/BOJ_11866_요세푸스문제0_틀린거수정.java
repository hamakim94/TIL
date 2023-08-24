package BOJ_220313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0_틀린거수정 {

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사람의 수
		int N = Integer.parseInt(st.nextToken());
		// K번째 사람 제거
		int K = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		Queue<Integer> queue = new LinkedList<>();

		// 1부터 N까지 하나씩 더해준다.
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		// 3번 쨰 사람을 비어있을 떄 까지 pop하기
		while (queue.size() > 1) {

			// K번째 사람이 들어오면 poll하고, 아니면 poll한걸 add해서(앞에 있는걸 뒤에 넣어서) 진행
			// K-1번까지 뽑고 넣어주기
			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");
		System.out.println(sb);

	}
}
