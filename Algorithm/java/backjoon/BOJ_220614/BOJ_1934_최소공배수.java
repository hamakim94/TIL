package BOJ_220614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int a;
		int b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int k = GCD(a, b);
			sb.append(a*b/k).append('\n');
		}
		System.out.println(sb);
	}

	private static int GCD(int a, int b) {
		if (a % b == 0)
			return b;

		return GCD(b, a % b);

	}
}
