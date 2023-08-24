package aps_220210;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// testCase 입력받구
		int testCase = sc.nextInt();
		// 그 수만큼 돌아~
		for (int test = 1; test <= testCase; test++) {
			// 이거 때문에 엄청오래걸렸다...
			int n = sc.nextInt();

			// 101개짜리 배열
			int[] arr = new int[101];
			// 입력을 받음과 동시에 해당 idx에 +=1 ;
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()] += 1;
			}
			// 최빈값의 인덱스를 저장할 변수
			int maxIdx = 0;
			// 최빈값을 저장할 변수 +
			int max = 0;
			for (int idx = 0; idx <=100; idx++) {
				// 현재 변수가, maxIdx의 값보다 크면!
				if ( max <= arr[idx]) {
					max = arr[idx];
					maxIdx = idx;
				}
			} // end for : 이제 최대값 max, maxIdx로 주어짐
			
			System.out.println("#" + n + " " + maxIdx);
		}
	}
}
