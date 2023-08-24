package BOJ_220603;

import java.util.Scanner;

public class BOJ_15651_N과M3 {
	
	static int N, M;
	static int[] sel;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1부터 N까지 자연수 중에서  
		M = sc.nextInt(); // M개를 골라야함(같은 수 여러 개 가능)
		sel = new int[M];
		sb = new StringBuilder();
		perm(0);
		System.out.println(sb);
	}
	static void perm(int lev) {
		// base case
		if(lev == M) {
			for(int k : sel) {
				sb.append(k).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			sel[lev] = i+1;
			perm(lev + 1);
		}
	}

}
