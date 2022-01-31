package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_2475_검증수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		// 제곱합을 구하기 위한 sq_sum
		int sq_sum = 0;
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(st.nextToken());
			// System.out.println(a);
			sq_sum += a * a;
		}
		System.out.println(sq_sum % 10);

	}
}
