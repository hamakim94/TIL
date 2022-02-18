package aps_220211;

import java.util.Scanner;

public class SWEA_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// 욕심 부리지말고, 하나씩 하자
			// 인풋 받기(가로길이 항상 100)

			int n = sc.nextInt();
			// 입력을 받을 배열
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			// 1. 최대, 최소값 찾기

			// 이걸 n번
			for (int j = 0; j < n; j++) {
				int max = -1;
				int min = 101;
				for (int i = 0; i < 100; i++) {
					if (max < arr[i]) {
						max = arr[i];
					}
					if (arr[i] < min) {
						min = arr[i];
					}
				} // end for : 최대 최소 찾기
					// 최대 인덱스에 -= 1, 최소 인덱스의 +=1,
				for (int i = 0; i < 100; i++) {
					if (arr[i] == max) {
						arr[i] -= 1;
						break;
					}
				}
				for (int i = 0; i < 100; i++) {
					if (arr[i] == min) {
						arr[i] += 1;
						break;
					}
				} // end for 1사이클
			} // end for : n번의 루프 완료

			// 최종 출력을 위한 최대/최소 찾기
			int max = -1;
			int min = 101;
			for (int f = 0; f < 100; f++) {
				if (max < arr[f]) {
					max = arr[f];
				}
				if (arr[f] < min) {
					min = arr[f];
				}
			}

			System.out.println("#" + tc + " " + (max - min));
		}
	}
}
