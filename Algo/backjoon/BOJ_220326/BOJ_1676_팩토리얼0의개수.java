package BOJ_220326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {

		// 구현한 걸로 보니, 0~4 : 0, 5~9 : 1, 10~14 : 2, 15~19 3: 20 : 4 까지 나와서
		// 그냥 n을 5로 나눈 몫으로 하기로 결정! 근데, 25꼴 곱해지면 2개씩 추가돼..
		// 배열을 만들자 그냥
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 구해야할 값.
		int n = Integer.parseInt(br.readLine());
		// 으악.. 25가 곱해지면 자리수 2개 추가구나, 5의 나눠지는 5의 개수에 따라 달라지네

		int[] cntZerosFact = new int[501];
		cntZerosFact[0] = 0;
		for (int num = 1; num <= 500; num++) {
			// 이전 값
			int before = cntZerosFact[num - 1];
			// 현재 idx를 계산하는 숫자
			int nowNum = num;
			// 소인수분해 했을 때 5의 개수
			int cntFives = 0;
			// 5보다 큰 경우에
			if (nowNum >= 5) {
				// 5로 나눴을때 0으로 떨어지면
				while (nowNum % 5 == 0) {
					// 5로 나눠진다
					cntFives += 1;
					// 5로 나눈걸 다시 nowNum에 넣기
					nowNum /= 5;
				}
			}
			// 이전 값 + cntFives로 개수 초기화
			cntZerosFact[num] = before + cntFives;
		}
		System.out.println(cntZerosFact[n]);

	}

	// factorial 구현 어떻게 할 진 모르지만, 아무튼 이런식으로 해봄, 팁좀
	public static long factorial(long n, long ans) {
		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return ans;
		} else {

			ans = n * factorial(n - 1, ans);
		}
		return ans;
	}
}
