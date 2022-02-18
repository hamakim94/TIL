package aps_220209;

import java.util.Scanner;

public class SWEA_list1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				if (max < num) {
					max = num;
				}

			}
			System.out.printf("#%d %d\n", i + 1, max);
		}
		sc.close();

	}
}
