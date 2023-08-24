package BOJ_220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304_������ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum += (a * b);
		}
		if(total == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
