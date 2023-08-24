package BOJ_220307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2_counting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 입력값 -min 이라는 인덱스의 + 1 해주고
		int[] cnt = new int[20000001];
		
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(st.nextToken())+10000000]++;
		}

		// 마지막에 입력받은 숫자들 - min의 인덱스를 출력하면 되겠다
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			sb.append(cnt[now + 10000000]).append(' ');
		}

		System.out.println(sb);
	}
}
