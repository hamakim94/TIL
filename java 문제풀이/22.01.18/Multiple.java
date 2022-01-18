package com.ssafy.hw01;

import java.util.Scanner;

public class Multiple {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input == 0)
			System.out.println("프로그램 종료");
		else {
			//아닌 경우 한 번 구구단 출력해주고
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", input, i, input * i);
			}
			// while문 돌면서 무한~
			while (true) {
				System.out.print("다음 숫자 입력 : ");
				input = sc.nextInt(); // input을 먼저 받기에, while 조건문 안에 넣지 않았다

				if (input == 0) {
					System.out.println("프로그램 종료");
					break;
				}
				System.out.print("다음 숫자 입력 : ");

				for (int j = 1; j < 10; j++) {
					System.out.printf("%d * %d = %d\n", input, j, input * j);
				}
			}
		}
	}
}
