package discord;

import java.util.Scanner;

public class SWEA_1940_가랏RC카 {

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int velocity = 0; // 속도
			int sum = 0; // 이동거리
			// 반복
			for (int i = 0; i < N; i++) {
				int now = sc.nextInt();
				if (now == 1) {
					velocity += sc.nextInt();
				} else if (now == 2) {
					velocity -= sc.nextInt();
					if (velocity < 0) {
						velocity = 0;
					}
				}
				sum += velocity;
			}
			System.out.println("#" + tc + " " + sum);

		} // end test Case

	}
}
