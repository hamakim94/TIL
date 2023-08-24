package BOJ_220318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 자료의 수
		int N = Integer.parseInt(br.readLine());

		

		// 우선 산술평균, 그냥 입력값들 다 더해주고, N으로 나누고,소수 첫째자리에서 반올림

		// 1. 산술평균을 위한 sum값
		double sum = 0;
		// 2. 중앙값을 위한 배열을 만들기
				int[] arr = new int[N];
		// 3. 개수를 세기 위한 hashMap
		HashMap<Integer, Integer> cnt = new HashMap<>();
		// 4. 범위를 위한 최댓값과 최소값
		int maxVal = -5001;
		int minVal = 5001;

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());

			// 1. 산술평균 구하기
			sum += now;
			// 2. 중앙값을 위한 배열
			arr[i] = now;

			// 3. 개수 세기
			if (!cnt.containsKey(now)) {
				cnt.put(now, 1);
			} else {
				cnt.put(now, cnt.get(now) + 1);
			}

			// 4. 범위 귀하기
			if (now > maxVal)
				maxVal = now;
			if (now < minVal)
				minVal = now;
		}
		// 1. 산술평균 출력 
		System.out.println(Math.round(sum / N));
		
		// 2. 중앙값을 위한 정렬
				Arrays.sort(arr);
		// 2. 중앙값 출력(홀수니 N/2 번쨰 값만 뽑으면 돼)
		System.out.println(arr[N / 2]);

		// 3. 최빈값을 구하기
		int maxCnt = Integer.MIN_VALUE;
		for (int key : cnt.keySet()) {
			if (maxCnt < cnt.get(key)) {
				maxCnt = cnt.get(key);
			}
		}

		// 최빈값의 key를 arrayList로 넣어두기
		List<Integer> maxCounts = new ArrayList<Integer>();
		for (int key : cnt.keySet()) {
			if (cnt.get(key) == maxCnt)
				maxCounts.add(key);
		}
		// 경우의 수 , 1개일때, 2개일때
		// 2개일 땐, sort해서 1번째 인덱스 뽑기
		if (maxCounts.size() >= 2) {
			maxCounts.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			System.out.println(maxCounts.get(1));
		}
		// 1개일 때 0번쨰 인덱스 봅기
		else {
			System.out.println(maxCounts.get(0));
		}

		// 4. 범위 출력
		System.out.println(maxVal - minVal);

	}
}
