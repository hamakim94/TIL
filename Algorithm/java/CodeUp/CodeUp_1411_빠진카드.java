package codeup_0120;

import java.util.Scanner;

public class CodeUp_1411_빠진카드 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 배열 만들기
		int[] arr = new int[n + 1];
		// 반복을 통해 입력받고 해당 번호에 인덱스에 +1 하기

		// 단순 반복
		for (int i = 0; i < n - 1; i++) {
			int tmp = sc.nextInt();
			arr[tmp] += 1;
		}
		for (int i = 1; i < n + 2; i++) {
			if (arr[i] == 0) {
				System.out.println(i);
				break;
			}
		}

	}

}
