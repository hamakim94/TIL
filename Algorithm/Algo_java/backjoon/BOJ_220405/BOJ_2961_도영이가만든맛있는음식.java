package BOJ_220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int N;
	static int[][] arr;
	static long minVal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자료의 수 N
		N = Integer.parseInt(br.readLine());

		// 입력 받기
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] now = br.readLine().split(" ");
			// 신맛 : 0 : 곱
			arr[i][0] = Integer.parseInt(now[0]);
			// 쓴맛 : 1, 합
			arr[i][1] = Integer.parseInt(now[1]);
		}

		// 최소값 초기화
		minVal = Long.MAX_VALUE;
		powerset();
		System.out.println(minVal);

	}

	// 부분집합을 계산해야함
	static void powerset() {
		// 신맛,쓴맛
		int shin = 1;
		int ssen = 0;
		// 부분집합의 개수 만큼
		for (int i = 0; i < (1 << N); i++) {
			// 그런데 최소한 한 개는 써야함
			int cnt = 0;
			// 초기화
			shin = 1;
			ssen = 0;
			// 여기선 개수만큼만돌아야함
			for (int j = 0; j < N; j++) {

				// 현재 숫자와 이진수 개수만큼 shifting했을 때 교집합이 0이 아니라면, 쓴다는거잖아
				if ((i & (1 << j)) != 0) {
					// j번쨰 원소 쓸래
					shin *= arr[j][0];
					ssen += arr[j][1];
					cnt++;
				}
			} // end for : 하나의 부분집합에서 쓴맛, 신맛 완료
				// 모두 안 세는건
			if (cnt > 0) {
				minVal = Math.min(minVal, Math.abs(shin - ssen));
			}
		}
	}

}
