package aps_220210;

import java.util.Scanner;

public class SWEA_2063_중간값찾기 {
	public static void main(String[] args) {

		// 입력받기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 답 인덱스
		int ansIdx = N / 2;

		// 배열 입력받기
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 선택정렬
		// 지금 내가 보고 있는게 최소값이라고 생각하고, 다 돌아!
		//
		for (int curIdx = 0; curIdx < N - 1; curIdx++) {
			// 지금 내 인덱스가 최소야!
			int minIdx = curIdx;
			for (int nowIdx = curIdx + 1; nowIdx < N; nowIdx++) {
				if (arr[minIdx] > arr[nowIdx]) {
					minIdx = nowIdx;
				}			
			} // end for : minIdx 찾기 완료
			// SWAP minIdx - curIdx
			int temp = arr[minIdx];
			arr[minIdx] = arr[curIdx];
			arr[curIdx] = temp;
		} // end for - 정렬 완료
		// System.out.println(Arrays.toString(arr));
		System.out.println(arr[ansIdx]);
	}
}
