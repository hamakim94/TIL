package backjoon_220205;

import java.util.Scanner;

public class backjoon_1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag;
		String str;
		int n;
		while (true) {
			flag = true;
			str = sc.next();
			if (Integer.parseInt(str) == 0) {
				break;
			}
			n = str.length();
			for (int i = 0; i < n / 2; i++) {
				if (str.charAt(i) != str.charAt(n - 1 - i)) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}
		sc.close();
	}
}
