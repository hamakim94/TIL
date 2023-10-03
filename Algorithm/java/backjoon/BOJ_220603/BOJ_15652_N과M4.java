package BOJ_220603;

import java.util.Scanner;

public class BOJ_15652_N과M4 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		sb = new StringBuilder();
		permUpper(0);
		System.out.println(sb);
	}

	static void permUpper(int lev) {

		if (lev == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (lev == 0) {
				arr[lev] = i;
			} else {
				if(i < arr[lev-1]) continue;
				arr[lev] = i;
			}
			permUpper(lev + 1);
		}

	}
}
