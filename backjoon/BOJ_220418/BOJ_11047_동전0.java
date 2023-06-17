package BOJ_220418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047_동전0 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int ans = Integer.parseInt(input[1]);
		int cnt = 0;
		int[] arr = new int[N];
		// 큰 수부터 거꾸로 넣었음돠.
		for (int i = N - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());

		}

		for (int i = 0; i < N; i++) {
			// 몫이 0이면 하지마
			int now = ans / arr[i];
			if (now == 0)
				continue;
			cnt += now;
			ans -= now * arr[i];
			// 나눴는데 0이면 멈춰
			if (ans == 0)
				break;

		}

		System.out.println(cnt);
	}
}
