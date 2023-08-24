package BOJ_220714;

import java.util.Scanner;

public class BOJ_2754_학점계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String now = sc.next();
		if (now.equals("A+")) {
			System.out.println(4.3);
		} else if (now.equals("A0")) {
			System.out.println(4.0);
		} else if (now.equals("A-")) {
			System.out.println(3.7);
		} else if (now.equals("B+")) {
			System.out.println(3.3);
		} else if (now.equals("B0")) {
			System.out.println(3.0);
		} else if (now.equals("B-")) {
			System.out.println(2.7);
		} else if (now.equals("C+")) {
			System.out.println(2.3);
		} else if (now.equals("C0")) {
			System.out.println(2.0);
		} else if (now.equals("C-")) {
			System.out.println(1.7);
		} else if (now.equals("D+")) {
			System.out.println(1.3);
		} else if (now.equals("D0")) {
			System.out.println(1.0);
		} else if (now.equals("D-")) {
			System.out.println(0.7);
		} else {
			System.out.println(0.0);
		}
	}
}
