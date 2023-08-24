package BOJ_220411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {

	static int[][] arr; // 입력받을 색종이s
	static int N; // 배열의 크기
	static int cntZero, cntOne; // 하얀식, 파란색

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		} // 입력 완료
		search(0, 0, N);
		System.out.println(cntZero);
		System.out.println(cntOne);
	}// end main

	private static void search(int rowStart, int colStart, int size) {

		int firstVal = arr[rowStart][colStart]; // 초기값 설정
		boolean flag = true; // 응 참
		for (int i = rowStart; i < rowStart + size; i++) {
			for (int j = colStart; j < colStart + size; j++) {
				// 달라지는 순간 뷁!!!
				if (arr[i][j] != firstVal) {
					flag = false;
					break;
				}
			}
		} // end for : 탐색 완료
			// 다 돌았는데도 같아?
		if (flag) {
			// 응 더해
			if (firstVal == 1)
				cntOne++;
			else
				cntZero++;
			// 다른 부분이 생겼어? 4부분으로 쪼개!
		} else {
			search(rowStart, colStart, size / 2); // 왼쪽 위
			search(rowStart + size / 2, colStart, size / 2); // 왼쪽 아래
			search(rowStart, colStart + size / 2, size / 2); // 오른쪽 위
			search(rowStart + size / 2, colStart + size / 2, size / 2); // 오른쪽 아래
		}

	}

}
