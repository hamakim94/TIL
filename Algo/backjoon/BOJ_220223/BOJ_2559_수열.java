package BOJ_220223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 인풋 넣기
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < N - M + 1; i++) {
			// M개 원소들의 합을 구하기 위한 변수
			int nowSum = 0;
			// M개만큼 돌면서 nowSum에 더해주기
			for (int j = i; j < i + M; j++) {
				nowSum += arr[j];
			} // 최댓값 찾기
			if (nowSum > maxValue) {
				maxValue = nowSum;
			}

		}
		System.out.println(maxValue);

	}
}
