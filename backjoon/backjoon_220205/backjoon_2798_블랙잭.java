package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		// arr 만듦
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		int max = 0;

		for (int i = 0; i < n - 2; i++) {
			
			for (int j = i + 1; j < n - 1; j++) {
				
				for (int k = j + 1; k < n; k++) {
					
					int total = arr[i] + arr[j] + arr[k];
					if (total == m) {
						System.out.println(m);
						return;
					} else if (total < m && max < total) {
						max = total;
					}
				}
			}
		}
		System.out.println(max);

	}
}
