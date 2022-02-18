package aps_220214;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		// 입력 받을 문자열 이름
		String str;
		for (int t = 1; t <= tc; t++) {

			str = sc.next();
			// 문자열의 길이
			int len = str.length();
			// while문을 돌 index
			int idx = 0;
			// 기본이 1이라고 생각하고, 아니면 flag 0으로 바꾸고 나와버리기
			boolean flag = true;
			// idx는 길이를 2를 나눈 몫보다 작은 값만 검사하면 됩니다. 길이가 6인 경우, 0,1,2만
			while (idx < len / 2) {
				// 하나 다른 순간 바로 나와!
				if (str.charAt(idx) != str.charAt(len - 1 - idx)) {

					flag = false;
					break;
				}
				idx++;
			} // end while : flag값 구해짐
			if (flag == true) {
				System.out.println("#" + t + " " + 1);
				continue;
			}
			System.out.println("#" + t + " " + 0);
		}

	}
}
