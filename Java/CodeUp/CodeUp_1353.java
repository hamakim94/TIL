package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1353 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.close();
		
		for ( int i = 0; i<n ; i++) {
			for (int j = 0 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}
}
