package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_11720_숫자의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String str_num = br.readLine();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += (int) str_num.charAt(i) - '0';
		}
		System.out.println(ans);
		br.close();
	}

}
