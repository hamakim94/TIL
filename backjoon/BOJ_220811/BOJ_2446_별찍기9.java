package BOJ_220811;

import java.util.Scanner;

public class BOJ_2446_º°Âï±â9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int k=0 ;k<i; k++) {
				sb.append(' ');
			}
			for(int j=2*(N-i)-1; j>0; j--) {
				sb.append("*");
			}
			sb.append('\n');
		}
		for(int i=N-2; i>=0; i--) {
			for(int k=0 ;k<i; k++) {
				sb.append(' ');
			}

			for(int j=2*(N-i)-1; j>0; j--) {
				sb.append("*");
			}
			
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
