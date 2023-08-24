package BOJ_220704;

import java.util.Scanner;

public class BOJ_2442_별찍기5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i=N; i>0; i--) {
			for(int k=N-i; k>0; k--) {
				sb.append(' ');
			}
			for(int j=1; j<=2*i - 1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
