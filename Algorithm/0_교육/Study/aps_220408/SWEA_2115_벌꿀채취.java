package aps_220408;

import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {

	static int N, M, C; // N : 벌집크기, 벌통크기, 한통최대꿀
	static int[][] arr;
	// 필요한 것들
	// 현재 좌표와, 담을 수 있는 최대값
	// 이거 가지고 첫번째로 큰거, 두번째로 큰거 가지고 마지막에 출력할거야
	static class Honey {
		int money;
		int r;
		int c;

		public Honey(int money, int r, int c) {
			super();
			this.money = money;
			this.r = r;
			this.c = c;
		}
		
		public static void main(String[] args) {
			// 입력 받기
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			
			for(int tc = 1; tc <= T; tc++) {
				N = sc.nextInt();
				M = sc.nextInt();
				C = sc.nextInt();
			}
	
			
		}

	}
}
