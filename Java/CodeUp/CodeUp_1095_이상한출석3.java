package codeup_0120;

import java.util.Scanner;

public class CodeUp_1095_이상한출석3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		//1 ~ 23까지니까.
		int mini = 24; 
		
		// 최소값 찾기~
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp < mini) 
				mini = tmp;
		}
		
		System.out.println(mini);

	}
}
