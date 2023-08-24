package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1274 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.close();
		
		int cnt = 1;

		for (int i = 2; i < n + 1; i++) {
			cnt = (n % i == 0) ? cnt++ : cnt;

		}

		if (cnt == 2) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}

	}
}
