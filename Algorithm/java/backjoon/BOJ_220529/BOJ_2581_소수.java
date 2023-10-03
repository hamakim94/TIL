package BOJ_220529;

import java.util.Scanner;

public class BOJ_2581_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		boolean[] check = new boolean[end+1];
		int[] nums = new int[end+1];
		// 값 대입
		for(int i=0; i<end+1; i++) {
			nums[i] = i;
		}
		check[1] = true;
		
		for(int i=2; i<end+1; i++) {
			// 방문했는데 false, 처음 만남, 그 이후엔 다 true로(소수 아님)
			if(!check[i]) {
				for(int j= i; j<end+1; j += i) {
					if(j == i) continue;
					check[j]=true;
				}
			}
		} // end 에라토스테네스 체
		int min = -1;
		int sum = -1;
		boolean checked = false;
		for(int i=start; i<end+1; i++) {
			if(check[i]) continue;
			sum += i;
			if(!checked) {
				checked=true;
				min = i;
			}
			
		}
		if(min == -1 && sum == -1) {
			System.out.println(-1);
		} else {
			System.out.println(sum+1);
			System.out.println(min);
		}
		
		
	}
}
