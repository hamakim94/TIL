package codeup_0120;

import java.util.Scanner;

public class CodeUp_1502_2차원배열채우기2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			                    // i=1일떄도 생각해야해..
			for (int j= i+1; j < i+n*n+1 ; j+=n ) { 
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
}

