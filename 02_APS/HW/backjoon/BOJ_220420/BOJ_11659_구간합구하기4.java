package BOJ_220420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {

		// 뭔가. .누적합을 구하면서 가야지 빠를거 같아.
		// for문 무친듯이 돌기 싫어!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				arr[i] = Integer.parseInt(st.nextToken());
			} else {
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			// right 까지의 누적합 - (left - 1)번까지의 누적합
			sb.append(arr[right] - arr[left - 1]).append("\n");
		}
		System.out.println(sb);

	}
}
