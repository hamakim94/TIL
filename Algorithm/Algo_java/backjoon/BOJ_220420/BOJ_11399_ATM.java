package BOJ_220420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	// 각 사람이 돈을 인출하는데 필요한 시간의 합을 구하는 문제.
	// 그리디하게 생각해서
	// 그냥 오름차순으로 정렬하고
	// 시간 합 구하면 된다고 생각합니다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		// 오름차순 정렬
		Arrays.sort(arr);
		// N 명의 데이터가 주어진다면
		// 첫 번쨰 원소 : N번 곱한거
		// 두 번쨰 원소 : N-1번 곱한거
		// ... 마지막 원소 : 1번 곱한거
		long cumSum = 0;
		for (int i = 0; i < N; i++) {
			cumSum += arr[i] * (N - i);
		}
		System.out.println(cumSum);
	}
}
