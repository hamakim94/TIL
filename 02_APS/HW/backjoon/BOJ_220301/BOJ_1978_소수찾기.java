package BOJ_220301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 개수
		int N = Integer.parseInt(br.readLine());
		// 입력배열
		String[] nums = br.readLine().split(" ");

		int cnt = 0;
		// for문을 돌면서 소수인지 판별
		for (int i = 0; i < N; i++) {
			cnt += isPrime(Integer.parseInt(nums[i]));
		}

		System.out.println(cnt);

	} // end main

	public static int isPrime(int a) {
		int cnt = 0;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0)
				cnt++;
		} // end for
			// 1과 자기 자신으로밖에 안 나눠지면 : 소수
		if (cnt == 2) {
			return 1;
		} // 아님 말구
		return 0;
	}
}
