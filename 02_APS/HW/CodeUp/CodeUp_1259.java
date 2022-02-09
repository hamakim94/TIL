package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1259 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int end = scan.nextInt();
		scan.close();
		int sum = 0;

		for (int i = 1; i < end + 1; i++) {
			if (i % 2 == 0)
				sum += i;
		}
		System.out.println(sum);

	}
}
