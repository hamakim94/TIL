package BOJ_220718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10699_5의수난2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		for (char a : br.readLine().toCharArray()) {
			ans += (long) Math.pow(a - '0', 5);

		}
		System.out.println(ans);
	}
}
