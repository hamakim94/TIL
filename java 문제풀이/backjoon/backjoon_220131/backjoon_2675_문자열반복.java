package backjoon_220131;

import java.util.Scanner;

public class backjoon_2675_문자열반복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 반복을 위한 n 받기
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			// 일단 한 번
			int num = sc.nextInt();
			String str = sc.next();

			for (char a : str.toCharArray()) {
				for (int j = 0; j < num; j++) {
					System.out.print(a);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
