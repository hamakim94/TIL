package aps_220407;

import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {

	static int N, B; // 자료개수, 높이
	static int[] nums;
	static int ans; // 만들어진 탑과 높이의 최솟값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			
			// 자료 입력 완료
			N = sc.nextInt();
			B = sc.nextInt();

			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			// 최솟값 초기화
			ans = Integer.MAX_VALUE;
			findMin(0, 0);
			//
			sb.append("#").append(tc).append(" ");
			sb.append(ans).append("\n");
		} // end testCase
		System.out.println(sb);
	}

	static void findMin(int idx, int sum) {
		// 혹시 몰라 가지치기, ans라는 수가 0이 나와버리면, 그냥 다 안해도 되니까
		if (ans == 0)
			return;

		if (idx == N) {
			// sum이 B보다 커지는 순간 ans 계산하기, 더 더하는 건 의미 없으므로 return
			if (sum >= B) {
				ans = Math.min(sum - B, ans);
				return;
			}

			// 아닌 경우 그냥 return;
			return;
		}
		// 넣어주고
		findMin(idx + 1, sum + nums[idx]);
		// 안 넣어주고
		findMin(idx + 1, sum);

	}

}
