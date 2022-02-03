package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1278 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		scan.close();
		int input = scan.nextInt();

		int n = 0;

		while (input != 0) {
			n += 1;
			input = (input - (input % 10)) / 10;
		}

		System.out.println(n);
		
	}
}
