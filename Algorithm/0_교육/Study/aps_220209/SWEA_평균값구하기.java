package aps_220209;

import java.util.Scanner;

public class SWEA_평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		// testCase 수 만큼 반복문을 돌자
		for (int tc = 1; tc <= testCase; tc++) {
			// 합을 저장할 변수 sum 설정
			int sum = 0;
			// 반복을 10번 돌면서 sum에 더해주기
			for (int i = 0; i < 10; i++) {
				sum += sc.nextInt();
			}
			// 출력을 하는데, 해당숫자 + 5 하고 10으로 나눈 몫 => 반올림 효과
			System.out.printf("#%d %d\n", tc, (sum + 5) / 10);
		}

		sc.close();
	}
}
