package aps_220218;

import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {

	public static void main(String[] args) {
		// 입력받기
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int tc=1 ; tc<=testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] cnt = new int[N+M+1];
			
			int max = Integer.MIN_VALUE;
			// 다 돌았구
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					cnt[i+j] += 1;
				}
			}
			for(int i=1; i <= N+M; i++) {
				max = Math.max(cnt[i], max);
			}
			
			System.out.print("#" + tc + " ");
			for(int i=1; i <= N+M; i++) {
				if(cnt[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
		}
	}

	
}
