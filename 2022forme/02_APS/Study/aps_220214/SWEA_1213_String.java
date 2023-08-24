package aps_220214;

import java.util.Scanner;

public class SWEA_1213_String {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str; // 문제 텍스트 저장할 공간
		String pattern; // 찾을 문자열 저장할 공간
		int cnt; // 개수 셀 공간

		// while문 써서 하는거 해보자
		for (int tc = 0; tc < 10; tc++) {
			int t = sc.nextInt();

			pattern = sc.next();
			str = sc.next();

			cnt = 0;
			int N = str.length();
			int M = pattern.length();
			int i = 0;
			int j = 0;

			while (i < N && j < M) {
				// 만약 2개 패턴 달라?
				if (str.charAt(i) != pattern.charAt(j)) {
					i -= j;// 너 되돌아가
					j = -1;// 너 -1해(나중에 ++ 때문에 가능)
				}
				i++;
				j++;
				// 만약 현재 인덱스 + 1 한 값이 찾을 문자열의 길이와 같다면
				if (j == M) {
					cnt += 1; // 1씩 카운트 해주고
					i -= (j - 1); // 현재 j는 찾을 문자열의 길이, 그거 -1 한 값을 시작점으로 주기 위해 j-1을 빼줌
					j = 0; // 0부터 시작하렴~
				}
			}
			System.out.println("#" + t + " " + cnt);

		}

	}
}
