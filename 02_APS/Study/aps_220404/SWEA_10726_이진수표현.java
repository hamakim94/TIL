package aps_220404;

import java.util.Scanner;

public class SWEA_10726_이진수표현 {
	public static void main(String[] args) {
		// 일단 첫번째 생각
		// M을 이진수로 표현하는데,
		// ""에 2로 나눈 나머지를 계속해서 더함. ( 역 이진수)
		// N번째 자리까지 substring해서 "1"이 N개 곱해진 거랑 비교해

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String binaryString = toBinanryStringReverse(M);
			// M을 이진수로
			if (N > binaryString.length()) {
				System.out.println("#" + tc + " OFF");
			} else {
				boolean flag = true;

				for (int i = 0; i < N; i++) {
					if (binaryString.charAt(i) == '1') {
						continue;
					}
					flag = false;
					break;
				}

				if (flag) {
					System.out.println("#" + tc + " ON");
				} else {
					System.out.println("#" + tc + " OFF");
				}
			}

		}
	}

	static String toBinanryStringReverse(int number) {
		if (number == 0) {
			return "0";
		} else {
			StringBuilder sb = new StringBuilder();
			while (number != 0) {
				sb.append(number % 2 + "");
				number /= 2;

			}
			return sb.toString();
		}

	}
}
