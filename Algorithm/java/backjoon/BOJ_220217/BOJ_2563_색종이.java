package BOJ_220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		int row; // 행
		int col; // 열
		int cnt = 0; // 개수세기
		// 입력받기

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());

			// 시작점 자체를 넓이라고 생각해서 1씩 더해주는 코드,
			// 정사각형 한 변의 길이가 10이므로
			for (int i = row; i < row + 10; i++) {
				for (int j = col; j < col + 10; j++) {
					// 비어있으면 1 채우고 cnt에 더해준다(중복 방지)
					if (arr[i][j] == 0) {
						cnt += 1;
						arr[i][j] = 1;
					}
				}
			} // end for : 개수세기

		} // end for
		System.out.println(cnt);
		br.close();
	}
}
