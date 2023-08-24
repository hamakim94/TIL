package aps_220211;

import java.util.Arrays;

public class List2_06_CountingSort {
	public static void main(String[] args) {

		int[] arr = { 5, 2, 4, 1, 2, 3, 3 };

		int N = arr.length; // 배열의 크기
		int K = -1; // 데이터의 최댓값

		// 최댓값
		for (int i = 0; i < N; i++) {
			if (K < arr[i]) {
				K = arr[i];
			}
		}
		
		// 최댓값도 인덱스로 쓰기 위해서..
		int[] count = new int[K+1];
		
		// 같은 크기!! 정렬된거 넣을 거
		int[] sorted = new int[N];
		
		//카운팅
		for(int i=0; i<N; i++) {
			count[arr[i]]++;
		}
		
		//누적합
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		// 정렬을 한다~~~!!!!!!
		for(int i= N-1; i>=0; i--) {
			// 나눠서 써보는것도 중요하다
			sorted[--count[arr[i]]] = arr[i];
		}
		
		System.out.println(Arrays.toString(sorted));
	}
}
