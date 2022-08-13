package BOJ_220813;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_25305_커트라인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		Integer[] nums = new Integer[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums, (o1, o2) -> o2-o1 );
			
		System.out.println(nums[k-1]);

		
	}
}
