package aps_220210;

import java.util.Scanner;

public class SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 인붓 받아서 반복
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			// 0. 누적합 변수
			int sum = 0;
			// 1. 주어진 배열 입력받기
			int[] arr = new int[10];
			// 1.
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			// 1-1. 최대값 / 최소값 찾기
			int max = -1;
			int min = 10001;
			for (int i = 0; i < 10; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}
			}
			// 2. bubbleSort 해보기
			// 2-1. 2개씩 비교해서, 큰거 오른쪽, 작은거 왼쪽!
			int temp;
			for (int i = arr.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					// 현재와 다음 원소를 비교하니..
					if (arr[j] > arr[j + 1]) {
						temp = arr[j + 1];
						arr[j + 1] = arr[j];
						arr[j] = temp;
					}
				}
			}
			// System.out.println(Arrays.toString(arr));
			// 3. 1 < 9까지 누적합
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}
			// 4. +5 / 10(자바 반올림)
			// 나눗셈 할 땐, 무적권 하나는 double형으로 써줘야해 like 2.0
			double mean = sum / 8.0;
			System.out.printf("#%d %d\n", test, (int) (mean * 10 + 5) / 10);

		}
	}
}
