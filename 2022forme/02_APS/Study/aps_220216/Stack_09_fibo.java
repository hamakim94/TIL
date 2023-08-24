package aps_220216;

import java.util.Arrays;

public class Stack_09_fibo {
	
	public static int[] count = new int[40];
	
	public static void main(String[] args) {
		System.out.println(fibo(38));
		//System.out.println(Arrays.toString(count));
	}
	
	public static int fibo(int n) {
		// 기본 파트 : 0,1값은 0, 1
		count[n]++;
		if(n<=1) return n;
		
		
		return fibo(n-1) + fibo(n-2);
			
	}
	// 굉장히 고급 스킬, 추후에 여러분들이 깊게 공부를 할 것
	// 중복 연산을 막기 위해서 사용하게 될 것.
	static int[] memo = new int[50];
	static {
		memo[1] = 1;
	}
	public static int fibo2(int n) {
		// 아직 구해진 적이 없음
		if (n >= 2 && memo[n] == 0){
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
}
