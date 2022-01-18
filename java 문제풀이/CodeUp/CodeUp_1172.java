package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1172 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int grade = scan.nextInt();
		int clas = scan.nextInt();
		int num = scan.nextInt();

		System.out.print(grade);

		if (clas < 10) {
			System.out.print("0" + clas);
		} else {
			System.out.print(clas);
		}

		if (num < 10) {
			System.out.print("00" + num);
		} else if (num < 100)  {
			System.out.print("0" + num);
		} else {
			System.out.print(num);
		}
		scan.close();
	}
}
