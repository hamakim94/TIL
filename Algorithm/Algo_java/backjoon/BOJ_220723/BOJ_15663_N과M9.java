package BOJ_220723;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_15663_N°úM9 {
	
	static int N, M;
	static int[] nums;
	static int[] sel;
	static boolean[] checked;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		sel = new int[M];
		checked = new boolean[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		perm(0);
		System.out.println(sb);
		sc.close();
	}
	static void perm(int level) {
		if(level == M) {
			String temp = "";
			for(int i=0; i<M; i++) {
				temp += sel[i];
			}
			if(set.contains(temp))
				return;
			for(int num : sel) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			set.add(temp);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!checked[i]) {
				sel[level] = nums[i];
				checked[i] = true;
				perm(level + 1);
				checked[i] = false;
			}
			
		}
	}
}
