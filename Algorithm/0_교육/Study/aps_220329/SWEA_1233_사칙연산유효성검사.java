package aps_220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {
	// boolean flag = false라고 생각하고
	// 불가능한 경우 0을 출력하고, 끝내구
	// 끝까지 계산 됐으면 ok!

	public static String[] heap;
	public static int[] nums;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {

			int N = Integer.parseInt(br.readLine());
			// 이제 이 N이 어디에 들어가는지 확인하기
			int k = 1;

			boolean flag = true;

			for (int i = 0; i < N; i++) {

				input = br.readLine().split(" ");

				int idx = Integer.parseInt(input[0]);

				if (input[1].equals("+") || input[1].equals("-") || input[1].equals("*") || input[1].equals("/")) {
					// N/2까진, 무조건 문자가 들어와야함
					if (idx <= N / 2)
						continue;
					else {
						flag = false;
					}
				} else {
					// ( N/2+1 ~ 입력값 N)까지는 무조건 숫자만 들어와야함
					if (idx > N / 2) {
						continue;
					} else {
						flag = false;
					}
				}
			} // end for, 입력 받기
			if (flag == false) {
				System.out.println("#" + tc + " " + 0);
			} else {
				System.out.println("#" + tc + " " + 1);
			}

		} // endTestCase

	}
}
