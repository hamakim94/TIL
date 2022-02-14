package BOJ_220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989_수정렬하기3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1. 입력 받기
		int n = Integer.parseInt(br.readLine());
		// 정답
		int[] arr = new int[n];
		int[] sorted = new int[n];

		// 2. 10001개짜리 arr 만들어서, count로 넣기
		int[] count = new int[10001];

		// count 세주고
		int temp;
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			count[temp] += 1;
			arr[i] = temp;
		}
		// 누적합
		for (int i = 1; i <= 10000; i++) {
			count[i] += count[i - 1];
		}

		// 이제 역으로 넣어주기
		for (int i = n - 1; i >= 0; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}

		for (int i : sorted) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);

	}
}
