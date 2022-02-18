package aps_220211;

public class List2_01_ArrayTest {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int N = arr.length; // 행 길이
		int M = arr[0].length; // 열 길이

		// 1. 행 우선순회
		// i(행의 값)을 고정시키고, j(열의 값)를 반복

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", arr[i][j]);
				// %3d : 3칸 확보하고 우측정렬!
			}
			System.out.println();
		}
		System.out.println();

		// 2. 행 역으로 순회
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				System.out.printf("%3d", arr[i][j]);
				// %3d : 3칸 확보하고 우측정렬!
			}
			System.out.println();
		}
		System.out.println();

		// 행우선순회 for문 하나로 돌 수도 있음 *언젠가

		// 3. 열 우선 순회 : j 고정
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				System.out.printf("%3d", arr[i][j]);
				// %3d : 3칸 확보하고 우측정렬!
			}
			System.out.println();
		}
		System.out.println();

		// 4. 열 역 순회 : j 고정
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				System.out.printf("%3d", arr[i][j]);
				// %3d : 3칸 확보하고 우측정렬!
			}
			System.out.println();
		}
		System.out.println();

		// 지그재그 순회 ( 짝수행은 정방향, 홀수행은 역방향
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
				System.out.println();
			} else {
				for (int j = M - 1; j >= 0; j--) {
					System.out.printf("%3d", arr[i][j]);
				}
				System.out.println();
			}
		}
		System.out.println();

		// 지그재그 순회 ( 짝수행은 정방향, 인덱스 가지고 놀기)
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
				System.out.println();
			} else {
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][M - 1 - j]);
				}
				System.out.println();
			}
		}
		System.out.println();

		// 컴퓨터쟁이들은 중복 선호 XX/
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// j와, M-1-j를 한번에 쓰고싶어
				// 그럼 2로 나눈 나머지를 활용해서 쓰고싶어
				// 따라서 j + (M-1-j-j)*(i%2)
				System.out.printf("%3d", arr[i][j + (M-1-2*j)*(i%2)]);
			}
			System.out.println();
		}
		System.out.println();

	}
}
