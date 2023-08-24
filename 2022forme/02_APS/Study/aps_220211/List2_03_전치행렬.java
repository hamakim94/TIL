package aps_220211;

import java.util.Arrays;

public class List2_03_전치행렬 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		int N = 3;
		
		System.out.println("원래의 모습");
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		// 전치행렬 , 이렇게 하면 안 돼, 2번 바꿔버렷
		for(int i =0 ; i<N; i++) {
			for (int j =0; j<N; j++) {
				// swap
				if(i<j) {
					int tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
				
			}
		}
		
		System.out.println("전치행렬 모습");
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
	}
}
