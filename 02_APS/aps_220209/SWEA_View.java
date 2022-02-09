package aps_220209;

import java.util.Scanner;

public class SWEA_View {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 이제 큰 걸로 감싸자!
		for (int tc = 1; tc <= 10; tc++) {
			// testCase가 100 : 총 96개의 빌딩, 2번 인덱스부터 97번 인덱스까지네
			int testCase = sc.nextInt();
			// 배열로 , 입력 완료!
			int[] arr = new int[testCase];
			for (int i = 0; i < testCase; i++) {
				arr[i] = sc.nextInt();
			}
			// 총 층수를 더하는 ans;
			int ans = 0;

			for (int i = 2; i < testCase - 1 - 1; i++) {
				// 우선 -2,-1,1,2 보다 큰걸 찾아보자

				// 빌딩 높이가 0이라면 하지마
				if (arr[i] == 0)
					continue;
				// 주변 4개가 모두 i번째 빌딩보다 작다면..
				if (arr[i - 2] < arr[i] && arr[i - 1] < arr[i] && arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
					// 이 4개중 최대값을 구하자.
					int max = 0;
					if (max < arr[i - 2])
						max = arr[i - 2];
					if (max < arr[i - 1])
						max = arr[i - 1];
					if (max < arr[i + 1])
						max = arr[i + 1];
					if (max < arr[i + 2])
						max = arr[i + 2];
					// ans라는 수에, 현재 높이 - 4개중 최대 빌딩 높이 
					ans += arr[i] - max;
				}

			} // end for : 큰거찾기!
			System.out.printf("#%d %d\n", tc, ans);
		}//end for : 입력 10개 받기
		sc.close();
	}

}
