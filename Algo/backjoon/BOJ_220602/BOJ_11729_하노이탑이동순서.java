package BOJ_220602;

import java.util.Scanner;

public class BOJ_11729_하노이탑이동순서 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int) Math.pow(2, N) - 1).append('\n');
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	private static void Hanoi(int n, int start, int mid, int to) {
		// base case
		if(n == 1) {
			sb.append(start).append(' ').append(to).append('\n');
			return;
		}
		
		Hanoi(n-1, start,to,mid);
		sb.append(start).append(' ').append(to).append('\n');
		Hanoi(n-1, mid, start, to);
		
	}
}
