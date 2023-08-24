package aps_220404;

import java.util.Arrays;

public class PermutationSwap {
	
	static int[] nums;
	static int N; // N개의 데이터를 이용
	
	public static void main(String[] args) {
		N = 3;
		
		nums = new int[] {0,1,2};
		perm(0);
	}
	
	// swap 메서드
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	// idx : 내가 판단하는 위치
	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for( int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i,idx);
		}
		
	}
	
}
