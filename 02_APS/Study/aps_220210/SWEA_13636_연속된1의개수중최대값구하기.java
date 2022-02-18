package aps_220210;

import java.util.Scanner;

public class SWEA_13636_연속된1의개수중최대값구하기 {
	public static void main(String[] args) {
		// 입력받기
		Scanner sc = new Scanner(System.in);
		// testCase 개수
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt();
			String str = sc.next();
			int max = 0;
			int cnt = 0;
			// 입력 받으면, for문을 돌면서
			for (int i = 0; i < n; i++) {
				// charAt(i)번째가 1이냐
				if (str.charAt(i) == '1') {
					// 1씩 더해
					cnt += 1;
					if (max < cnt) {
						max = cnt;
					}
					// 만약 다음에 0 만나면 max값과 비교
				} else {
					cnt = 0;
				}

			} // end for : 최대값 찾음
			System.out.println("#" + t + " " + max);
		} // 최종 end for
		sc.close();

	}

}
