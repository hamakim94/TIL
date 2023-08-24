package aps_220211;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		// 2에서 시작해서, 왼쪽, 오른쪽, 위만 올라갈거야
		Scanner sc = new Scanner(System.in);
		// 우선 배열을 입력 받아야함
		int[][] arr = new int[100][100];
		for(int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
}
