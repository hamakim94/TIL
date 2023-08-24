package BOJ_220213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		// 카운팅 정렬을 해보자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력 받기 : 총 수 n
		int n = Integer.parseInt(br.readLine());
		// 입력을 넣을 배열 : arr
		int[] arr = new int[n];
		// 배열 값 넣기. + 바로 최댓값. 최솟값 찾기(음수인 경우도 있어서)
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}

		}
		br.close();
		int minusMin = 0;
		// 음수가 0 이상이라면, 그냥 최솟값을 0으로 하자
		if (min >= 0) {
			minusMin = 0;
		} else {
			minusMin = -min;
		}
		// 1. 최댓값 + 1 크기의 count 배열 만들기
		int[] count = new int[max + minusMin + 1];
		// 2. 여기에 카운팅 해주기
		for (int i = 0; i < n; i++) {
			count[arr[i] + minusMin] += 1;
		}
		// 3. 누적합 해주기
		for (int i = 0; i < max + minusMin; i++) {
			count[i + 1] += count[i];
		}
		// 이 배열을 활용해, 새로운 배열에 넣어주기
		int[] sorted = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			sorted[--count[arr[i]+minusMin]] = arr[i];
		}
		// 최종 출력
		for (int val : sorted) {
			sb.append(val).append('\n');
		}
		System.out.println(sb);
	}
}
