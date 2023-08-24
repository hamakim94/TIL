package aps_220221;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			
			double h = (2*(x+y) - Math.sqrt(4*(x+y)*(x+y) - 12*x*y))/12;
			double ans = 4*h*h*h - 2*(x+y)*h*h + h*x*y;
			System.out.printf("#%d %.6f\n" , test_case, ans);
		}
	}
}
