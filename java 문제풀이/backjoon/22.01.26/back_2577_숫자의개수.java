package back220126;

import java.util.Scanner;

public class back_2577_숫자의개수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		sc.close();

		int result = a * b * c;
		String k = Integer.toString(result);
		
		System.out.println(k.length());
		int[] ans = new int[10];
//
		for (int i = 0; i < k.length(); i++) {
			ans[Character.getNumericValue(k.charAt(i))] += 1;
		}
		System.out.println(ans.toString());
//		for ( int i : ans) {
//			System.out.println(i);
//		}
	}
}
