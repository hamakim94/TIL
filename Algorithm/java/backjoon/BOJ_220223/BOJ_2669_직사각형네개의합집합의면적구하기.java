package BOJ_220223;

import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// map 만들고
		int[][] map = new int[101][101];
		// 최종 넓이 구할거
		int cnt = 0;
		// 4번 돌거야
		for (int tc = 0; tc < 4; tc++) {
			// 좌표 저장할 배열 및 입력
			int[] arr = new int[4];
			for (int j = 0; j < 4; j++) {
				arr[j] = sc.nextInt();
			} // 반복문을 돌면서, 없으면 1 넣어주고 넓이 +=1; 아니면 넘어가
			for (int r = arr[0]; r < arr[2]; r++) {
				for (int c = arr[1]; c < arr[3]; c++) {
					if (map[r][c] == 0) {
						map[r][c] = 1;
						cnt++;

					}
				}
			}
		} // end for 다 셌음
		System.out.println(cnt);

	}
}
