package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1355 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = n - i; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
