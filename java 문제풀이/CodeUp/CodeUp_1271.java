package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1271 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int maxi = -2147000000;
		
		for(int i=0; i<n; i++) {
			int b = scan.nextInt();
			if (b > maxi) {
				maxi = b;
			}
		}
		System.out.println(maxi);
		scan.close();
	}
}
