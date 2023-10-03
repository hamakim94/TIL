package BOJ_220531;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		if (N == 0) {
			System.out.println(0);
		} else if (N == 1) {
			System.out.println(1);
		} else {
			arr[0] = 0;
			arr[1] = 1;
			for (int i = 2; i < N + 1; i++) {
				arr[i] = arr[i - 2] + arr[i - 1];
			}
			System.out.println(arr[N]);
		}
	}
}
