package BOJ_220626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_7662_이중우선순위큐 {

	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pqMin, pqMax;
		StringBuilder sb = new StringBuilder();
		// I : 추가,

		// 최댓값과 최솟값 출력하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			pqMin = new PriorityQueue<>();
			pqMax = new PriorityQueue<>(Collections.reverseOrder());
			int N = Integer.parseInt(br.readLine());
			map.clear();
			for (int i = 0; i < N; i++) {
				
				String[] input = br.readLine().split(" ");

				String val = input[0]; // 문자, D, I
				int num = Integer.parseInt(input[1]); // 숫자, 1, -1, 우선순위
				if (val.equals("I")) {
					pqMin.add(num);
					pqMax.add(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					// D : 1 : 최댓값 삭제, -1 : 최소값 삭제
					if (num == 1) {
						delete(pqMax);
					} else {
						delete(pqMin);
					}
				}
			} // end for: testCase
			if (map.size() != 0) {
				sb.append(delete(pqMax)).append(' ').append(delete(pqMin)).append('\n');
			} else {
				sb.append("EMPTY").append('\n');
			}

		}
		System.out.println(sb);
	}

	private static int delete(PriorityQueue<Integer> que) {
		int res;
		if (map.size() == 0)
			return 0;
		while (true) {
			res = que.poll();
			int cnt = map.getOrDefault(res, 0);
			if (cnt == 0)
				continue;
			if (cnt == 1)
				map.remove(res);
			else {
				map.put(res, cnt - 1);
			}
			break;

		}
		return res;

	}
}
