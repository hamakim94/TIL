package aps_220210;

import java.util.Scanner;

public class SWEA_1204_최빈수구하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// testCase 입력받구
		int testCase = sc.nextInt();
		// 그 수만큼 돌아~
		for (int test = 1; test <= testCase; test++) {
			int N = sc.nextInt();
			// 1001개짜리 배열
			int[] arr = new int[1001];
			// 입력을 받음과 동시에 해당 idx에 +=1 ;
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()] += 1;
			}
			// 최대값을 저장할 변수 + 해당 idx값을 저장할 변수
			int maxIdx = 0;
			for (int idx = 0; idx < arr.length; idx++) {
				// 현재 변수가, maxIdx의 값보다 크면!
				if (arr[maxIdx] <= arr[idx]) {
					maxIdx = idx;
				}
			} // end for : 이제 최대값 max, maxIdx로 주어짐
			System.out.println("#" + N + " " + maxIdx);
		}
	}
}
