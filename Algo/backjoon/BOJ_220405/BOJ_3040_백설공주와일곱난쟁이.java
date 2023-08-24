package BOJ_220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {

	// 결국 문제는, 9C7 해서 합이 100인거 찾기
	static int[] ans = new int[7];
	static int[] nums = new int[9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 완료
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0, 0);

	}

	// idx : nums돌거, sidx : 조그만 배열 돌 거, sum : 중간중간 합
	static void comb(int idx, int sidx, int sum) {
		if (sidx == 7) {
			if (sum == 100) {
				for (int num : ans) {
					sb.append(num).append("\n");
				}
				System.out.println(sb);
			}

			return;
		}
		if (idx == 9) {
			return;
		}

		// 이제 넛기
		ans[sidx] = nums[idx];
		comb(idx + 1, sidx + 1, sum + nums[idx]);
		comb(idx + 1, sidx, sum);

	}

}