package back220126;

import java.util.Scanner;

public class back_10950_AplusB3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
		}
		sc.close();
	}
}

