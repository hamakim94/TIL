package BOJ_220301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws IOException {
		// input 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N : 크기
		int N = Integer.parseInt(br.readLine());
		// nums : 원래 배열
		int[] nums = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}

		// arr : 입력값들
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(input2[i]);
		}
		// 일단 기존 배열을 오름차순 정렬
		Arrays.sort(nums);

		// 각 요소마다 넣어서, 있으면 1 반환, 없으면 말고
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(0, N - 1, arr[i], nums));
		}

		// 이진 탐색 시작
	} // end main

	public static int binarySearch(int lt, int rt, int ans, int[] arr) {
		// 이진 탐색하는 것
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (ans > arr[mid]) {
				lt = mid + 1;
			} else if (ans < arr[mid]) {
				rt = mid - 1;
			} else { // 여기는 만약 ans == arr[mid]:1 반환하고 끝내버림
				return 1;
			}
		} // end while
		return 0;
	}

}
