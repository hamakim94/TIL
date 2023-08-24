package BOJ_220321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	public static long[] arr;
	public static long maxVal;
	// 나무의 수
	public static long N;
	// 나무 높이의 합
	public static long M;

	public static void main(String[] args) throws IOException {

		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 나무의 수
		N = Long.parseLong(st.nextToken());
		// M : 가져가려고 하는 나무의 길이
		M = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 나무의 높이를 담을 배열
		arr = new long[(int) N];
		// 나무 높이의 최대값
		maxVal = 0;

		for (int i = 0; i < N; i++) {
			long now = Long.parseLong(st.nextToken());
			arr[i] = now;
			if (maxVal < now)
				maxVal = now;
		}

		// 수가 생각보다 크다! -> long을 사용하자
		// 어떤 수의 최대 높이 !! 이진탐색을 할 예정!!
		long lt = 1;
		long rt = maxVal;
		// 최대 높이
		long mid = 0;
		while (lt <= rt) {
			mid = (lt + rt) / 2;
			long sumHeight = getHeights(mid);
			// 그럼, 가져갈 나무들 < M미터
			if (sumHeight < M) {
				// 절단기의 최대높이를 더 낮게!
				// 더 많이짤라!! (rt = mid - 1)
				rt = mid - 1;
			}
			// 가져갈 나무들 >= M 미터
			else {
				// 절던기의 최대높이를 더 높게! : 
				// 더 조금잘라도 돼!
				// lt = mid +1
				lt = mid + 1;
			}
		}
		System.out.println(rt);

	}

	public static long getHeights(long height) {
		long sumHeights = 0;

		for (int i = 0; i < N; i++) {
			// 1. 나무의 높이 > 절단기의 최대 높이
			if (arr[i] > height)
//			    -> 가져갈 나무s + 나무 - 절단기의 최대 높이
				sumHeights += (arr[i] - height);
		}

		return sumHeights;
	}
}
