package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class backjoon_2231_분해합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		br.close();

		for (int i = 1; i <= input; i++) {
			
			// 자릿수 합 용 : sum
			int sum = 0;
			//  number : 자릿수를 구하기위해 임시적으로 사용되는 변수
			int number = i;

			// 자릿수 합 구하기
			while (number != 0) {
				sum += number % 10;
				number = number / 10;
			}

			if (sum + i == input) {
				System.out.println(i);
				return; // return문을 만나면 끝나!
			}
		}
		System.out.println(0);
		// 두번째 풀이, 자릿수를 각
	}
}
