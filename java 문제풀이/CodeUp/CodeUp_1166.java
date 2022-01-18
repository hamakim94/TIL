package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1166 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int year = scan.nextInt();

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

		scan.close();

	}
}
