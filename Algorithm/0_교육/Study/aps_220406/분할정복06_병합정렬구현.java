package aps_220406;

import java.util.Arrays;

public class 분할정복06_병합정렬구현 {

	// 할 배열
	static int[] arr = { 7, 123, 5, 42, 89, 89, 30, 29 };
	static int[] sortedArr = new int[arr.length];

	public static void main(String[] args) {
		mergeSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	// 두 부분으로 나눈다

	static void mergeSort(int left, int right) {
		// 1. 나누기
		// 끝나는 조건 ; left < right일 때만.
		if (left < right) {
			// left, right, mid값 조정해가면서 챠챠챡 나눠
			// 왼쪽
			// 오른쪽
			// 2. 병합 및 정렬하기
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}
	// 2. 병합 및 정렬하기(arr, left, mid, right)

	static void merge(int left, int mid, int right) {
		// L이라는 변수에 left값 저장
		// R이라는 변수에 mid + 1 값 저장
		int L = left;
		int R = mid + 1;
		// 정렬으로 넣어주기 위한 변수 idx = left(시작점)
		int idx = L;
		// while문 돌면서, L <= mid 고 R <= right 일 때
		while (L <= mid && R <= right) {
			// 만약 arr[L] <= arr[R} 이면
			if (arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++];
			// 반대면, R에 있는게 더 작을 떄
			else
				sortedArr[idx++] = arr[R++];
			// sortedArr[idx++] = arr[R++]
		}
		// 어느순간, 커지는게 생기니까
		// 만약 L <= mid 라면 (L에 남은게 있다면)
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 반대라면, R에 남는게 있다면
		else {
			for (int j = R; j <= right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		// 이제, 복붙
		for (int t = left; t <= right; t++) {
			arr[t] = sortedArr[t];
		}

	}

}
