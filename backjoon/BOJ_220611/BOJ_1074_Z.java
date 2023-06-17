package BOJ_220611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

	// N : 2의 N승 r 몇번째 행 c 몇번째 열
	static int N, R, C, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		ans = 0;
		dc(0, 0, size);
	}

	// 가로길이를 가지고 ,2*2로 나눠서, 왼위, 오위, 왼아래, 왼오
	private static void dc(int r, int c, int size) {
		// base case
		if (size == 1) {
			System.out.println(ans);
			return;
		}

		int newSize = size / 2;
		// 1사분면
		if (R < r + newSize && C < c + newSize) {
			dc(r, c, newSize);
		}
		if (R < r + newSize && c + newSize <= C) {
			ans += (size * size) / 4;
			dc(r, c + newSize, newSize);
		}
		if (r + newSize <= R && C < c + newSize) {
			ans += ((size * size) / 4)*2;
			dc(r+newSize, c , newSize);
		}
		if (r + newSize <= R  && c + newSize <= C) {
			ans += ((size * size) / 4)*3;
			dc(r+newSize, c + newSize, newSize);
		}

	}

}
