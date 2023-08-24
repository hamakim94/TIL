package aps_220218;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		int N; // N명의 손님
		int M; // M초의 시간을 들이면
		int K; // K개 만들 수 있음

		int[] customer; //
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			customer = new int[N];
			for (int i = 0; i < N; i++) {
				customer[i] = sc.nextInt();
			}
			// 시간 순서대로 정렬
			Arrays.sort(customer);

			String ans = "Possible";

			for (int i = 0; i < N; i++) {
				if ((customer[i] / M) * K < i + 1) {
					ans = "Impossible";
					break;
				}
			}
			
			System.out.println("#" + tc + " " + ans );

		}

	}
}
