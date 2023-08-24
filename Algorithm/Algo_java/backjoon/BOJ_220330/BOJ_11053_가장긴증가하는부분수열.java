package BOJ_220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N이 1인 경운 그냥 답이 1
		if (N == 1) {
			System.out.println(1);
		} else {

			// 수열 입력
			int[] arr = new int[N];
			// 자신이 들어갔을 때 얻을 수 있는 최대 수열 길이를 저장하는 배열
			int[] num = new int[N];
			// 최대 수열의 길이
			int ans = 0;
			// 입력 받기
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 뒤에서부터돌거야
			// 맨 마지막 값에는 무조건 1 넣어주고. 자기 자신은 들어가니까!
			num[N - 1] = 1;

			for (int i = N - 2; i >= 0; i--) {
				// 그 다음부터,자기보다 큰 수의 값 중 최대값 + 1;

				int findBigNum = 0;
				for (int j = i + 1; j < N; j++) {
					// 자기보다 큰 수의, num 배열 최대값 찾기
					if (arr[i] < arr[j]) {
						// 최대로 들어갈 수 있는 수
						if (num[j] > findBigNum) {
							findBigNum = num[j];
						}
					}

				} // end for : 넣을 수 있는 최대값 찾음
					// 현재 보고있는 위치에 가장 큰 값을 넣어주기
				num[i] = 1 + findBigNum;
				// 이제 최대값 찾기
				if (ans < num[i])
					ans = num[i];
			}
			System.out.println(ans);
		}
	}
}
