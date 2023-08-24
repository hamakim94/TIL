package BOJ_220628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int N;
	static int[][] arr;
	static int[] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cnt = new int[3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end for : input
		DC(0, 0, N);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt[0]).append('\n').append(cnt[1]).append('\n').append(cnt[2]);
		System.out.println(sb);
	}

	static void DC(int row, int col, int size) {
		if (size == 1) {
			cnt[arr[row][col] + 1]++;
			return;
		}
		int start = arr[row][col];
		boolean flag = true;
		outer: for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != start) {
					flag = false;
					break outer;
				}
			}
		}
		if (flag) {
			cnt[start + 1]++;
			return;
		} else {
			for (int i = row; i < row+size ; i += size / 3) {
				for (int j = col; j < col+size ; j += size / 3) {
					DC(i, j, size / 3);
				}
			}
		}

	}
}
