package aps_220331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {
	// 부모
	public static int[] p;
	// 왼자
	public static int[] l;
	// 오른자
	public static int[] r;
	public static StringTokenizer st;

	public static int V, E, idx1, idx2, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			
			p = new int[10001];
			l = new int[10001];
			r = new int[10001];
			
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			idx1 = Integer.parseInt(st.nextToken());
			idx2 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				p[end] = start;
				if (l[start] == 0) {
					l[start] = end;
				} else {
					r[start] = end;
				}
			}
			int newIdx = idx1;
			while (newIdx >0 ) {
				int temp = p[newIdx];
				p[newIdx] = -1;
				newIdx = temp;

			}

			newIdx = idx2;
			while (p[newIdx] != -1) {
				int temp = p[newIdx];
				newIdx = temp;

			}
			count = 0;
			LVR(newIdx);
			System.out.println("#" + tc + " " + newIdx + " " + count );
		} // end testCase

	} // end main

	public static void LVR(int idx) {
		if (idx != 0) {
			count++;
			LVR(l[idx]);
			LVR(r[idx]);
		} else {
			return;
		}
	}
}
