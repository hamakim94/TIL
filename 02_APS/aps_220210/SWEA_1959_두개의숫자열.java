package aps_220210;

import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {

	static int diff;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int testCase = sc.nextInt();

		for (int test = 1; test <= testCase; test++) {

			// 입력받는 배열의 개수를 담기위한 함수
			int n = sc.nextInt();
			int m = sc.nextInt();

			// 배열을 만들고
			int[] arrN = new int[n];
			int[] arrM = new int[m];

			// 배열에 넣는다.
			for (int i = 0; i < n; i++) {
				arrN[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				arrM[i] = sc.nextInt();
			}
			// System.out.println(Arrays.toString(arrM));

			// 최대값 찾는 값
			int max = Integer.MIN_VALUE;
			// 누적합을 위한 값
			int cumsum;
			// 3가지 경우의 수, m>n ; m<n ; m==n
			if (n < m) {
				// 차이값을 구하고
				diff = m - n;

				// 차이값만큼 for문을 돌면서 순회할거야
				for (int subDif = 0; subDif <= diff; subDif++) {
					cumsum = 0;
					for (int i = 0; i < n; i++) {
						cumsum += (arrN[i] * arrM[i + subDif]);
						// System.out.println(arrN[i] + " " + arrM[i + subDif]);
					} // end for : get cumsum
						// System.out.println("cumsum " + cumsum);
					if (max < cumsum) {
						max = cumsum;
					}

				} // end for
				System.out.printf("#%d %d\n", test, max);

			} else if (n > m) {
				// 차이값을 구하고
				diff = n - m;
				// 차이값만큼 for문을 돌면서 순회할거야
				for (int subDif = 0; subDif <= diff; subDif++) {
					cumsum = 0;
					for (int i = 0; i < m; i++) {
						cumsum += (arrM[i] * arrN[i + subDif]);
						// System.out.println(arrM[i] + " " + arrN[i + subDif]);
					} // end for : get cumsum
						// System.out.println("cumsum " + cumsum);
					if (max < cumsum) {
						max = cumsum;
					}
				} // end for "
				System.out.printf("#%d %d\n", test, max);
			} else {
				cumsum = 0;
				for (int i = 0; i < n; i++) {
					cumsum += (arrM[i] * arrN[i]);
					// System.out.println(arrM[i] + arrN[i]);
				} // end for
				System.out.printf("#%d %d\n", test, max);
			}
		}

	}
}
