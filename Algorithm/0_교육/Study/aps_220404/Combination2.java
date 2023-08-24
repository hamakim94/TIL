package aps_220404;

import java.util.Arrays;

public class Combination2 {
	static int[] data; // 정수형 자료형의 모임.
	static int[] sel; // 내가 뽑은 것들을 저장할 배열
	static int N, R; // N개 중 R개 뽑기

	public static void main(String[] args) {

		data = new int[] { 10, 11, 12, 13, 14 };
		N = 5;
		R = 3;
		sel = new int[R];

		comb(0, 0);
	}// main

	// idx : 실제 data 배열의 idx

	static void comb(int idx, int sidx) {
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = data[i];
			comb(i + 1, sidx + 1);
		}

	}
}
