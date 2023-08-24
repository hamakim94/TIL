package BOJ_220611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416_피보나치수1 {
	static int back, dp;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		back = 0;
		dp = 0;
		fib(N);
		dp(N);
		System.out.println(back + " " + dp);

	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			back++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);

	}

	static int dp(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			dp++;
		}
		return arr[n];
	}
}
