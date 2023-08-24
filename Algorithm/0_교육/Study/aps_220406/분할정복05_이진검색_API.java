package aps_220406;

import java.util.Arrays;

public class 분할정복05_이진검색_API {

	public static void main(String[] args) {

		int[] arr = { 1, 7, 9, 13, 19, 28, 31, 39, 41 };
		
		// 인덱스 값을 반환한다.
		System.out.println(Arrays.binarySearch(arr, 40));

	}

}
