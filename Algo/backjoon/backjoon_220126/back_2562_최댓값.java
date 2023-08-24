package back220126;

import java.util.Scanner;

public class back_2562_최댓값 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int maxi = -1000001;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			if (num > maxi) {
				maxi = num;
				idx = i+1;
			}
		}
		System.out.println( maxi);
		System.out.println(idx);

		sc.close();
	}
}
