package com.ssafy.hw01;

import java.util.Scanner;

public class Season1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.print("월 입력>>");
			int input = sc.nextInt();
			if (input >= 3 && input <= 5)
				System.out.printf("%d월은 봄입니다\n", input);
			else if (input >= 6 && input <= 8)
				System.out.printf("%d월은 여름입니다\n", input);
			else if (input >= 9 && input <= 11)
				System.out.printf("%d월은 가을입니다\n", input);
			else
				System.out.printf("%d월은 겨울입니다\n", input);
		}
	}
}
