package aps_220406;

import java.util.Arrays;

public class 분할정복07_퀵정렬_호어파티션 {

	public static void main(String[] args) {

		int[] arr = { 7, 5, 40, 11, 8, 8, 56, 39 };
		quickSort(arr, 0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {

		int pivot = arr[left];
		int L = left + 1, R = right;
		int tmp;

		while (L <= R) {
			// L : pivot보다 큰 값을 찾을 때 까지 이동하겠다..
			// 요기 제한 범위를 두지 않으면 인덱스에러가 날 수 도 있음. 꼭 꼮!!!
			// 손으로 그리기
			while (L <= R && arr[L] <= pivot)
				L++;
			// R : pivot보다 작거나 같은 값을 만날 때 까지 이동하겠다.
			while (arr[R] > pivot)
				R--;
			// 아직 교차가 안 됐니? 더 해볼게 남았으니 일단 서로 교환
			if (L < R) {
				tmp = arr[L];
				arr[R] = arr[L];
				arr[R] = tmp;
			}
		}
		// pivot이 가리키는 값과 R이 가리키는 값을 바꾸어 pivot의 위치를 결정
		tmp = arr[left]; // pivot
		arr[left] = arr[R];
		arr[R] = tmp;
		return R;
	}
}
