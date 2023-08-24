package BOJ_220324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2x타일링 {
	public static void main(String[] args) throws IOException {

		// 직접 그려보니, 피보나치네
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 여기 N+1로 설정 안 해서 틀림
		long[] arr = new long[1001];
		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			arr[i] %= 10007;
		}

		System.out.println(arr[N]);

	}
}
