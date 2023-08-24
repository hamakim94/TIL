package back220126;

import java.util.Scanner;

public class back_10952_AplusB5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == 0 && b == 0) {
				break;
			}
			System.out.println(a + b);
			
		}
		sc.close();
	}
}
