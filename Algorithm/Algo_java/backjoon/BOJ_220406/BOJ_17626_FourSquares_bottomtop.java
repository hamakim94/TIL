package BOJ_220406;

import java.util.Scanner;

public class BOJ_17626_FourSquares_bottomtop {
	// 최대 4개까지니까.
	static int minVal = 4;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		DFS(0,n);
		System.out.println(minVal);
	}
	// 쵯 ㅗ네
	// L : level, depth, n : 정수
	private static void DFS(int L, int n) {
		// 일단 제곱수 구해
		int k = (int) Math.sqrt(n);
		
		// base case
		if(n == k*k) {
			minVal = Math.min(L+1, minVal);
			// 여기서 되는 순간 그냥 출력하고 끝.
			return;
		}
		if(L == 4) {
			return;
		}
		
		for(int i = k; i>0; i--) {
			if(n - (i*i) > 0) {
				DFS(L+1, n-i*i);
			}
			else
				return;
			
		}
	}
}
