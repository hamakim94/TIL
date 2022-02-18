package aps_220218;

import java.util.Arrays;

public class PowerSet_Bit {
	public static void main(String[] args) {

		String[] ingre = { "단무지", "당근", "참치", "햄" };
		
		int N = 4;
		// 1<< N == 1* (2의 N제곱)
		for (int i = 0; i < (1 << N); i++) {
			// 사실, 0부터 15까지가, 비트연산자로 보면 4비트의 부분집합 0101 모음
			// 각각의 요소를 검사하기 위한 반복문이 필요ㅕ
			for (int j = 0; j < N; j++) {
				// i라는 부분집합 요소에서 요소를 하나씩 검사행한다
				// i의 j번쨎 비트에 값이 있는지를 체크하고 싶다

				// if ( (i & (1<<j)) == 1) { i<<j가 생각보다 1이 아님(아버지를 아버지라 부르지 못하고, 그래서 0보다 커야함)
				if ((i & (1 << j)) > 0) {
					System.out.print(ingre[j]);
				}
			}
			// 작업 하자
			System.out.println(":김밥");

		}

	}
}
