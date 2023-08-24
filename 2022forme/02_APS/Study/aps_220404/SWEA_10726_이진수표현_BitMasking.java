package aps_220404;

import java.util.Scanner;

public class SWEA_10726_이진수표현_BitMasking {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 마지막 N개 자리수
			int N = sc.nextInt();
			// 이진수로 표현해야함, 근데 컴퓨터는 알아서 해줌
			int M = sc.nextInt();
			
			boolean flag = true;
			
			for(int i=0; i<N; i++) {
				if( (M & (1<<i)) == 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println("#" + tc + " ON");
			} else {
				System.out.println("#" + tc + " OFF");
			}
			
			
			

		}
	}

}
