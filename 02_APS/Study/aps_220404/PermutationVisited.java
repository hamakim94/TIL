package aps_220404;

import java.util.Arrays;

public class PermutationVisited {

	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static int N; // N개의 데이터를 이용

	public static void main(String[] args) {
		N = 3;

		nums = new int[] { 0, 1, 2 };
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
	}

	private static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] == true) {continue;}
			
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
