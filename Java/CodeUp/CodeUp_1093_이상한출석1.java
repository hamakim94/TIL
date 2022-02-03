package codeup_0120;

import java.util.Scanner;

public class CodeUp_1093_이상한출석1 {
	public static void main(String[] args) {

		// 입력을 위한 sc
		Scanner sc = new Scanner(System.in);

		// 입력받는 횟수
		int n = sc.nextInt();

		// 1부터 23까지~ 0부터 22까지 0으로 초기화된 배열을 만들어보자

		int[] arr = new int[23];

		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			// k-1인 이유는 인덱스는 0부터 시작하기 떄문에
			arr[k-1] += 1;
		}
		
		for (int i = 0; i < 23; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
