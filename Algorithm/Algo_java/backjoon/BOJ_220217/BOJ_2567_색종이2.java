package BOJ_220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		int row; // 행
		int col; // 열
		int cnt = 0; // 개수세기
		// 입력받기

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());

			// 시작점 자체를 넓이라고 생각해서 1씩 더해주는 코드,
			// 정사각형 한 변의 길이가 10이므로
			for (int i = row; i < row + 10; i++) {
				for (int j = col; j < col + 10; j++) {
					// 비어있으면 1 채운다
					if (arr[i][j] == 0) {
						arr[i][j] = 1;
					}
				}
			} // end for : 정사각형에 1채우기

		} // end for
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				// 4방탐색을 하면서, 하나라도 0이 나오거나, 범위를 벗어난다면(경계값) cnt ++;
				if (arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int newR = i + dr[k];
						int newC = j + dc[k];
						if (arr[newR][newC] == 0 || newC== 0  || newR ==0 || newR > 100 || newC > 100) {
							cnt++;
						}
					}
				}

			}
		}
		System.out.println(cnt);
	}
}
