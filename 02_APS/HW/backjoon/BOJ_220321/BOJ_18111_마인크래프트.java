package BOJ_220321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
	public static int N, M, B, minVal, maxVal;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {

		// 어떻게 하는게 옳을까. 생각해보니.. 땅을 고르는데 걸리는 시간과 땅의 높이 출력하긴데
		// 땅 고르기 작업에 걸리는 최소 시간과, 그 경우 땅의 높이를 출력해야함.

		// 우선 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행의 수
		N = Integer.parseInt(st.nextToken());
		// 열의 수
		M = Integer.parseInt(st.nextToken());
		// 인벤토리
		B = Integer.parseInt(st.nextToken());

		// N*M 배열 생성
		arr = new int[N][M];

		// 높이의 최소값 :
		minVal = 257;
		maxVal = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > maxVal)
					maxVal = arr[i][j];
				if (arr[i][j] < minVal)
					minVal = arr[i][j];
			}
		} // end for : 입력, 배열 최소,최대값 설정 완료

		// 순수하게 높이의 관점에서만 생각해보자.
		List<int[]> timeHeight = new ArrayList<>();

		// 걸리는 시간의 최솟값을 구하기
		int minTime = Integer.MAX_VALUE;
		// 1. 최소 시간, 최대 높이값 구하기
		for (int height = minVal; height <= maxVal; height++) {
			// 2. 최소 높이부터 최대 높이까지 걸리는 시간 구하기............
			int wholeTime = getTime(height);
			if (wholeTime != -1) {
				// 걸리는 시간과, 높이를 구해서 ArrayList에 더해줌
				int[] k = { wholeTime, height };
				timeHeight.add(k);

				// 최소 시간 구하기
				if (minTime > wholeTime) {
					minTime = wholeTime;
				}
			}
		}
		// 높이들을 담을 ArrayList
		List<Integer> heights = new ArrayList<>();
		// 이제 ArrayList를 돌면서, 최소시간 찾기
		for (int i = 0; i < timeHeight.size(); i++) {
			if (timeHeight.get(i)[0] == minTime) {
				heights.add(timeHeight.get(i)[1]);
			}
		}
		// sort하면 오름차순
		heights.sort(null);
		// 가장 마지막꺼 , 즉 최댓값 추출
		System.out.println(minTime + " " + heights.get(heights.size() - 1));

	}// end main
		// 높이가 주어졌을 때 걸리는 시간을 반환하는 함수

	public static int getTime(int height) {
		// 현재 인벤토리 수는, 늘 B여야 함
		int now = B;
		// 기준높이보다 큰 높이(깎아야함) -> 시간 2초 , B++;
		int cntLarge = 0;
		// 기준높이보다 작은 높이(쌓아야함)
		int cntSmall = 0;

		int time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 기준높이보다 큰 높이(깎아야함) -> 시간 2초 , B++;
				if (arr[i][j] > height) {
					int blocks = (arr[i][j] - height);
					cntLarge += blocks;
					time += 2 * blocks;
				// 기준높이보다 작은 높이(쌓아야함) -> 시간 1초, B++;
				} else if (arr[i][j] < height) {
					int blocks = (height - arr[i][j]);
					cntSmall += blocks;
					time += blocks;
				}
			}
		} // end for : 더 큰거, 더 작은거 개수 셈 완료
			// 그 넣어야할게 더 많은 경우에는 인벤토리 체크
		if ((now + cntLarge) >= cntSmall) {
			return time;
		}
		// 불가능하다고
		return -1;
	}

}
