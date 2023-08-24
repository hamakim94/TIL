package aps_220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			// 사이즈
			
			N = Integer.parseInt(br.readLine());

			// 배열로
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 최종 이익
			long sum = 0;
			int max = 0;
			// 거꾸로 돌면 되는거네..
			for(int i=N-1; i>=0; i--) {
				max = Math.max(arr[i], max);
				if(max > arr[i]) {
					sum += (max -arr[i]);
				}
			}

			System.out.println("#" + tc + " " + sum);
		} // end testCases
	} // end main

}
