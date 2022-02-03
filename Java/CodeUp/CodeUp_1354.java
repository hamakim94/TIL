package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1354 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.close();
		for (int i = n ; i > 0 ; i--) {
			for(int j = i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
