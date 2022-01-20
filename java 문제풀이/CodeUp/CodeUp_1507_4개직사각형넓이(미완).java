package codeup_0120;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_1507_4개직사각형넓이 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] x_maxi = new int[100];
		int[] x_mini = new int[100];
		// 최대, 최소 설정
		int[] maxi = new int[100];
		int[] mini = new int[100];
		for (int i = 0; i<100;i++) {
			mini[i] = 100;
		}
		for (int k = 0; k < 4; k++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int i = x1; i < x2 + 1; i++) {
				if (y1 < mini[i]) {
					mini[i] = y1;
					x_mini[i] = y1;
				}
				if (y2 > maxi[i]) {
					x_maxi[i] = y2;
				}
			}
			
		}
		System.out.println(Arrays.toString(x_maxi));
		System.out.println(Arrays.toString(x_mini));
	}
}
