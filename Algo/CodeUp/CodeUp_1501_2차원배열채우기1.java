package codeup_0120;

import java.util.Scanner;

public class CodeUp_1501_2차원배열채우기1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// 일단 n번 반복
		for (int i = 0; i < n; i++) {
			// j의 시작점 : 1부터 시작이니, i*n + 1, 끝점은 (i+n) + n + 1
			for (int j = i * n + 1; j < (i * n) + n + 1; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}
}
