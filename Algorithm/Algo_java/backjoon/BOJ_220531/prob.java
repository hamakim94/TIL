package BOJ_220531;

import java.util.Arrays;
import java.util.Scanner;

public class prob {
	static int[] arr = { 1, 5, 4, 2, 9, 7 };

	public static void main(String[] args) {
		// n 입력 2 2번 flip
		// a, b 입력 1 3 // *7 + 15 % 7 : 뒤집기 공식
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = sc.nextInt();
		int end = sc.nextInt();

		for (int k = 0; k < N; k++) {
			filp(start, end);
		}
		System.out.println(Arrays.toString(arr));

	}
	static void filp(int a, int b) {
		for(int i=a; i<=b; i++) {
			arr[i] = arr[i]*7 + 15;
			arr[i] %= 7;
		}
	}
}
