package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1172 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();

		if (a >= b) {
			if (b >= c) {
				System.out.println(c + " " + b + " " + a);
			} else {
				if (a >= c) {
					System.out.println(b + " " + c + " " + a);
				} else {
					System.out.println(b + " " + a + " " + c);
				}
			}
		} else {
			if (a >= c) {
				System.out.println(c + " " + a + " " + b);
			} else {
				if (c >= b) {
					System.out.println(a + " " + b + " " + c);
				} else {
					System.out.println(a + " " + c + " " + b);
				}
			}
		}
	}

}
