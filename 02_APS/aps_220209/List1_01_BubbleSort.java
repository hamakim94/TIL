package aps_220209;

import java.util.Arrays;

public class List1_01_BubbleSort {
	public static void main(String[] args) {

		int[] nums = { 55, 7, 78, 12, 42 };

		int N = nums.length;
		// 오름차순, 버블 소트

		// 몇 번 돌지 + 정렬될 위치를 결정해주는 for문
		for (int i = N - 1; i > 0; i--) {
			// 시작부터 인접한 값을 비교해야 하므로(그 다음원소
			// 등호를 생략해야 (N-2 N-1)까지 비교가 가능하다
			for (int j = 0; j < i; j++) {
				// 인접 두 수 중 앞에 친구가 더 크다면!
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		
		//굳이 거꾸로 말고 처음부터 돌 수도 있음!
	
		System.out.println(Arrays.toString(nums));
	}
}
