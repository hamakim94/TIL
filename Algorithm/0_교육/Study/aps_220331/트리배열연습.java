package aps_220331;

import java.util.Arrays;
import java.util.Scanner;

public class 트리배열연습 {
	public static int[] tree;
	public static int[] left;
	public static int[] right;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		tree = new int[50];
		left = new int[50];
		right = new int[50];
		for (int i = 1; i <= N - 1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			tree[start] = 1;
			tree[end] = 1;
			// tree[end] = 1;
			// 왼쪽 자식 비어있으면
			if (left[start] == 0) {
				left[start] = end;
			} else {
				right[start] = end;
			}
		} // end for
		System.out.println(Arrays.toString(tree));
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		// 전위 순회
		VLR(1);
	}

	public static void VLR(int idx) {

		if (tree[idx] != 0) {
			System.out.println(idx);
			VLR(left[idx]);
			VLR(right[idx]);
		} else {
			return;
		}
	}
}
