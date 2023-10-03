package codeup_0120;

import java.util.Scanner;

public class CodeUp_1096_바둑판흰돌 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 반복문 설정을 위한 n 받기
		int n = sc.nextInt();

		// 19*19 2차원 배열 만들기
		int[][] map = new int[19][19];

		for (int i = 0; i < n; i++) {
			// 각 원소를 받기
			int dr = sc.nextInt();
			int dc = sc.nextInt();
			// map이라는 2차원 배열에 원소를 1로 넣기
			map[dr - 1][dc - 1] = 1;
		}
		// 이제 프린트
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
