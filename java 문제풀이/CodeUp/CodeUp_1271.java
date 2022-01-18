package com.ssafy.codeup;

import java.util.Scanner;

public class CodeUp_1271 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		// 우선 최대값을 찾기 위해 최소값을 해야함.
		// 그런데 조건 최대값이 너무 크면 int 쓰면 안 되는 경우 있음(21억 초과)
		int maxi = -2147000000;
		
		for(int i=0; i<n; i++) {
			// for문 돌면서 한 번 씩 nextint로 정수 받기
			int b = scan.nextInt(); 
			// 만약 b가 작은 수보다 크면, 큰 수를 maxi에 저장!
			maxi = (b > maxi) ? b : maxi; // 삼항연산자 가능!
//			if (b > maxi) {  
//				maxi = b;
//			}
		}
		System.out.println(maxi);
		scan.close();
	}
}
