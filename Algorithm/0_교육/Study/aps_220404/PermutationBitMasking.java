package aps_220404;

import java.util.Arrays;

public class PermutationBitMasking {

	static int[] nums;
	static int[] result;
	static int N; // N개의 데이터를 이용

	public static void main(String[] args) {
		N = 3;

		nums = new int[] { 0, 1, 2 };
		result = new int[N];

		perm(0, 0);
	}

	private static void perm(int idx, int visited) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < N; i++) {
			// 내가, 현재 i번쨰 원소를 사용했는지 쳌
			if ((visited & (1 << i)) != 0) {
				// 해당 원소는 썻다
				continue;
			}
			
			result[idx] = nums[i];
			// 박문철이 이거 가져가~ 이미 비트 안에 1,0,이 들어가서 챠라락댐!
			perm(idx + 1, visited | 1<<i);
		}
	}

}
