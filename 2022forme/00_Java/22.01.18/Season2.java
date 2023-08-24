package com.ssafy.hw01;

import java.util.Scanner;

public class Season2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = 0;

		while (num < 3) {
			num++;
			System.out.print("월 입력>>");
			int inputNum = sc.nextInt();
			switch (inputNum) {
			case 3:
			case 4:
			case 5:
				System.out.printf("%d월은 봄입니다.\n", inputNum);
				break;
			case 6:
			case 7:
			case 8:
				System.out.printf("%d월은 여름입니다.\n", inputNum);
				break;
			case 9:
			case 10:
			case 11:
				System.out.printf("%d월은 가을입니다.\n", inputNum);
				break;
			default:
//			case 12:
//			case 1:
//			case 2:
				System.out.printf("%d월은 겨울입니다.\n", inputNum);

			}
		}
	}
}
