package codeup_0120;

import java.util.Scanner;

public class CodeUp_1094_이상한출석2 {
	public static void main(String[] args) {

		// 입력을 위한 sc
		Scanner sc = new Scanner(System.in);

		// 입력받는 횟수
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		// 하나씩 받기
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		// 거꾸로 출력
		for (int i=n-1; i>=0; i--) {
			System.out.print(arr[i] + " ");
		}
		
//		// 거거꾸로 출력  = > 다른사람의 코드를 봐야하는 이유
//		for (int i=0; i<n; i++) {
//			System.out.print(arr[n-1-i] + " ");
//		}

	}
}
