package BOJ_220609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948_베르트랑공준2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[250000];

		for (int i = 2; i < 250000; i++) {
			if (arr[i] == 0) {
				if (isPrime(i)) {
					arr[i] = 1;
					for (int j = i + i; j < 250000; j += i)
						arr[j] = i;
				}
			}

		}

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int ans = 0;
			int start = N + 1;
			int end = 2 * N;
			for (int num = start; num <= end; num++) {
				if (arr[num] == 1)
					ans++;
			}
			sb.append(ans).append('\n');

		}
		System.out.println(sb);
	}

	static boolean isPrime(int num) {
		if (num == 1)
			return false;
		int cnt = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				cnt++;
		}
		if (cnt == 1) {
			return true;
		}
		return false;
	}
}
