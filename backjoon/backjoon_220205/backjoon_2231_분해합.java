package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class backjoon_2231_분해합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		br.close();
		
		
		// 첫번쨰 접근방식 틀린점 : 생성자들로만 생성자가 만들어지지 않아.. 5에 대한 생성자도 따로 있어.

		ArrayList<Integer> arr = new ArrayList<>();

		// sum = 0으로 하고, 생성자로 만들기!

		//
		arr.add(1);
		int i = 0;

		// 언제까지? 마지막 배열의 값이 입력값보다 작으면 실행! 크면 멈춰!
		while (arr.get(i) < input) {
			// sum : 생성자 더할 공간, now : 현재 위치를 받음
			int sum = 0;
			int now = arr.get(i);
			sum += now;
			while (true) {
				if (now / 10 == 0) {
					i += 1;
					sum += now % 10;
					arr.add(sum);
					break;
				} else {
					sum += now % 10;
					now = now / 10;
				}
			}
		}
		System.out.println(arr.toString());
//		if (arr.get(i) == input) {
//			System.out.println(arr.get(i));
//		} else {
//			System.out.println("0");
//		}
	}
}
