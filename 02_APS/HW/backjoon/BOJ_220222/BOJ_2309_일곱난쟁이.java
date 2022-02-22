package BOJ_220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sumValue = 0;
		// 입력 받기 + 합 구하기
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sumValue += arr[i];
		}
		// 정렬하고
		Arrays.sort(arr);
		// i.j를 for문 돌면서, i번쨰,j번째만 스킵하고 돈 것의

		aa : for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sumValue - arr[i] - arr[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i) {
							continue;
						}
						if (k == j) {
							continue;
						}
						System.out.println(arr[k]);

					} // end for : 출력
					break aa;
				}

			}
		}
	}
}
