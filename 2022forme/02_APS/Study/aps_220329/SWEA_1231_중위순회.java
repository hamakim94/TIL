package aps_220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1231_중위순회 {
	public static String[] heap;
	public static int[] left;
	public static int[] right;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// testCase 수
		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#" + tc + " ");
			// 총 노드의 수
			int N = Integer.parseInt(br.readLine());
			
			
			// 이럴수가.. 사실... 입력값이 1,2,3,4,5.. 이미 자체가 완전 이진 트리..
			// 이렇게 입력을 받을 필요가 없었다!
			heap = new String[101];
			left = new int[101];
			right = new int[101];
			// split했을 때 문장의 길이 기준으로 입력을 받아볼까
			for (int i = 0; i < N; i++) {
				// 입력 받기
				String[] input = br.readLine().split(" ");

				if (input.length == 4) {
					int now = Integer.parseInt(input[0]);
					heap[now] = input[1];
					int leftIdx = Integer.parseInt(input[2]);
					left[now] = leftIdx;
					int rightIdx = Integer.parseInt(input[3]);
					right[now] = rightIdx;
				} else if (input.length == 3) {

					int now = Integer.parseInt(input[0]);
					heap[now] = input[1];
					int leftIdx = Integer.parseInt(input[2]);
					left[now] = leftIdx;
				} else {
					int now = Integer.parseInt(input[0]);
					heap[now] = input[1];

				} // end if
			} // end for : 입력 완료

			// 이제 재귀 돌아야함
			inOrder(1);
			sb.append("\n");
		}
		System.out.println(sb);

	} // end main

	public static void inOrder(int idx) {

		if (heap[idx] != null) {
			inOrder(idx * 2);
			sb.append(heap[idx]);
			inOrder(idx * 2 + 1);
		}
	}
}
