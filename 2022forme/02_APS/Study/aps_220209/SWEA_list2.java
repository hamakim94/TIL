package aps_220209;

import java.util.Scanner;

public class SWEA_list2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 이제 전체를 for문으로 돌려보자.
		int total = sc.nextInt();
		for (int k = 0; k < total; k++) {
			// 일단 하나 리스트 받아 정렬하는거부터 만들어
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// arr이라는 배열에 bubblesort 해보자
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j + 1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}
			System.out.printf("#%d ", k + 1);
			for (int i = 0; i < N; i++) {
				System.out.printf("%d ", arr[i] );
			}
			System.out.println();
		}
		sc.close();

	}
}
