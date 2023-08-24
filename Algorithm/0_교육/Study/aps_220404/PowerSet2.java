package aps_220404;

import java.util.Arrays;

public class PowerSet2 {

	static int N, K;
	static int[] nums; // 
	static int[] sel; // 해당 원소 포함 여부 저장

	public static void main(String[] args) {
		// 재귀 호출 이용
		N = 4;
		nums = new int[] { 1, 2, 3, 4 };
		sel = new int[N];

		powerset(0);
	}
	// k는 depth라고 생각하기
	static void powerset(int k) {
		if(k == N) {
			for(int i=0; i<N; i++) {
				if (sel[i] != 0) {
					System.out.print(nums[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		// 이제, 빼고 넣기 순으로 할거야
		
		sel[k] = 1;
		powerset(k+1);
		sel[k] = 0;
		powerset(k+1);
	}

	
}
