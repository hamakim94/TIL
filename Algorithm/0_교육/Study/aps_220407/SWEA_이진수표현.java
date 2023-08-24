package aps_220407;

import java.util.Scanner;

public class SWEA_이진수표현 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 3칸 이동 : 1을 왼쪽으로 세칸 이동 - 1 => 111,
			int check = (1<<N)-1;
			// 교집합의 결과가 자기 자신이면 모두 1
			if( (check & M) == check) {
				System.out.println("#" + tc + " " + "ON");
			}
			else {
				System.out.println("#" + tc + " " + "OFF");
			}
		}
	}
}
