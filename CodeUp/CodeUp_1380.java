package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1380 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		for (int i = 1; i < 7; i++) {
			for (int j = 6; j > 0; j--) {
				if (i + j == n) {
					System.out.println(i + " " + j);
				}

			}
		}

	}
}
