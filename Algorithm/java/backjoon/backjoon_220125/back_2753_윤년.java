package back220125;

import java.util.Scanner;

public class back_2753_윤년 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();
		if ( (year%4 == 0 && year%100 != 0) || year%400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
