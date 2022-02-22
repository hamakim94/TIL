package BOJ_220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();

		// 하나하나씩 넣어준다.
		for (int i = 1; i <= n; i++) {
			que.add(i);
		}
		// 딱 2개만 남았을 떄 까지
		while (que.size() >= 2) {
			// 2개를 뽑는다
			que.poll(); // 현재 뽑은거 -> 다시 안 넣는다
			int next = que.poll(); // 다음에 뽑은거
			que.add(next); // -> 다시 넣는다

		} // end while : 1개만 남음
		System.out.println(que.peek());
		
		// 최대한 peek로 접근하자. poll 사용하니 NullPointerException 발생..
		// 근데 뭐가틀린걸까.

	}
}
