package codeup_0120;

import java.util.Scanner;

public class CodeUp_1492_누적합배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		for (int i=0 ; i<n ; i++) {
			sum += sc.nextInt();
			System.out.print(sum + " ");
		}
		
	}
}
