package aps_220217;

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {
		// 입력 먼저 받기
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		String str;
		for (int tc = 1; tc <= testCase; tc++) {

			int n = sc.nextInt(); // 크기
			char[][] arr = new char[n][n];
			// 배열 입력받기
			for (int i = 0; i < n; i++) {
				str = sc.next();
				arr[i] = str.toCharArray();
			}

			int center = n / 2; // 인덱스로 가줄거야
			int cnt = 0; // 최종 더해줄 값

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Math.abs(i-center) + Math.abs(j - center) <= center) {
						// char형 연산, -를 만나는 순간 int로 형변환되니까, '0'을 빼줘서 숫자값을 더해준다
						cnt += arr[i][j] - '0'; 
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}

	}
}
