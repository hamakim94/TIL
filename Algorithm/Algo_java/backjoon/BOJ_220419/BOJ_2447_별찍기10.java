package BOJ_220419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447_별찍기10 {
	// 별을 뽑기 위한 배열을 선택해서, 한 줄씩 뽑을거야
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		makeStar(0, 0, N, false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	private static void makeStar(int r, int c, int N, boolean check) {
		

		// check == True면, 아무것도 뽑지 마, 빈칸으로 둬, 
		// check == true를 먼저 해야지, 아래 부분에서 안 덮어씌워짐
		if (check) {
			for (int i = r; i < r + N; i++) {
				for (int j = c; j < c + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		// N == 1일 때(계속 3으로 나눌 수) 그냥 찍기
		if (N == 1) {
			arr[r][c] = '*';
			return;
		}
		
		
		// 재귀
		int size = N / 3;
		int cnt = 0; // 5번째 칸만, 아무것도 하지 마!
		for (int i = r; i < r + N; i += size) {
			for (int j = c; j < c + N; j += size) {
				cnt++;
				// 5번째 칸이면, 공백스 다 넣어줘
				if (cnt == 5)
					makeStar(i, j, size, true);
				// 아니면, 그냥 false로 하고 끝.
				else
					makeStar(i, j, size, false);

			}
		}

	}
}
