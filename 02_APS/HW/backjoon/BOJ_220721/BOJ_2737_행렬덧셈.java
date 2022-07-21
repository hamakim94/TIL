package BOJ_220721;

import java.util.Scanner;

public class BOJ_2737_Çà·Äµ¡¼À {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] += sc.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] += sc.nextInt();
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
}
