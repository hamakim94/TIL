package BOJ_220402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {

	public static String now;

	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 입력 완료

		HashSet<String> listen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}

		ArrayList<String> ans = new ArrayList<>();

		// 놀라운 점
		// ArrayList의 contains는 indexOf를 사용하기 때문에 O(n)이고
		// HashSet(map)의 contains 는 HashMap기반이고, O(1)이라고 한다
		for (int j = 0; j < N; j++) {
			now = br.readLine();
			if (listen.contains(now)) {
				ans.add(now);
			}
		}
		// 이제. HashMap에 있는 2개짜리만 따로모아..?
		// 자동 오름차순 메서드, 내림차순에는 reverse가 있다
		Collections.sort(ans);

		sb.append(ans.size());
		for (String k : ans) {
			sb.append("\n");
			sb.append(k);
		}

		System.out.println(sb);
	}
}
