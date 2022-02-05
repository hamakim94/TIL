package backjoon_220131;

import java.util.Scanner;

public class backjoon_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;

		int input1 = Integer.parseInt(sc.next());
		int input2 = input1;

		// 일단 한 단계 접근하는거부터 만들자
		while (true) {
			int ten = input2 / 10;
			int ze = input2 % 10;

			int new_num = ze * 10 + (ten + ze) % 10;
			cnt += 1;
			if (new_num == input1) {
				break;
			}
			input2 = new_num;
		}
		System.out.println(cnt);
		sc.close();
	}
}
