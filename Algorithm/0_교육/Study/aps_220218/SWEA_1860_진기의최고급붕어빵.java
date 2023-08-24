package aps_220218;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		int N; // N명의 손님
		// 진기의 능력
		int M; // M초의 시간을 들이면
		int K; // K개 만들 수 있음
		int max; //
		int now; // 현재 시간까지 만들어놓은 빵의 개수
		int[] arr; //
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			now = 0;
			max = Integer.MIN_VALUE;
			// 입력 받기 // 최대값 찾기(마지막 손님이 온 시간
			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(arr[i], max);
			}
			// 시간 순서대로 정렬
			Arrays.sort(arr);

			int time = 1; // 1초부터 시작하자
			int idx_arr = 1; // 도착 시간 배열에 첫번째 원소부터 하자
			boolean flag = true;
			a: while (true) {
				// 만약 해당 인덱스 번호가 M으로 나누어 떨어지면, 현재 붕어빵 개수 + K개
				if (time % M == 0) {
					now += K;
				}
				// 현재 돌고있는 시간가, 손님 도착 시간과 같다면, 현재 붕어빵 수 -1, 손님 도착 시간 인덱스 + 1
				while (time == arr[idx_arr]) {
					now--;
					idx_arr++;
					
					if (idx_arr > arr.length - 1) {
						flag = true;
						break a;
					}
				}
				// 만약 현재 붕어빵 개수가 음수가 나오면, 걍 틀렸으니 빠져나와
				if (now < 0) {
					flag = false;
					break a;
				}//  다 돌았는데도 괜찮아
				time++;

			}
			if (flag) {
				System.out.println("#" + tc + " " + "Possible");
			} else {
				System.out.println("#" + tc + " " + "Impossible");
			}

		}

	}
}
