package aps_220209;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class List1_02_SelectionSort {
	public static void main(String[] args) {
		int[] nums = {64, 25, 10, 22, 11};
		int N = nums.length;
		
		for(int i = 0; i<N-1; i++) {
			// 인덱스 값만 따로 저장
			int minIdx = i;
			for (int j = i+1 ; j<N; j++) {
				// 현재 보고있는 j번째 값이 내가 가장 작다고 믿고 있는 값보다 더 작다면..
				if(nums[j] < nums[minIdx])
					// 여기서 계속 j를 바꿔주니까, 결국 최소로 돼
					minIdx = j;
			}
			// idx자리와 해당 j를 바꿔줌
			int tmp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = tmp;
		}
		System.out.println(Arrays.toString(nums));
		
	}
}
