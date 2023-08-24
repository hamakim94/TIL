package com.ssafy.hw01;

import java.util.Scanner;

public class MultipleDoWhile {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input == 0)
			System.out.println("프로그램 종료");
		else {
			do {
				for (int i =0; i<10; i++) {
					System.out.printf("%d * %d = %d\n", input, i, input*i);
				}
				System.out.print("다음 숫자 입력 : ");
				input = sc.nextInt();
			}while(input != 0);
			System.out.println("프로그램 종료");
				
		}
	}
}
