package BOJ_220711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N과M8 {
	static int N, M;
	static int[] arr, nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int level) {
		if(level == M) {
			for(int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(level > 0 && arr[level-1] > nums[i]) continue;
			arr[level] = nums[i];
			perm(level + 1);
		}

	}
}
