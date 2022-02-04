package backjoon_220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1085_직사각형에서탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// 경우

		// x 자체, w - x
		// y 자체, y - x

		int[] arr = { x, w - x, y, h - y };

		int min = Math.max(w, h) + 1;

		for (int i : arr) {
			if (i < min) {
				min = i;
			}
		}
		System.out.println(min);

	}
}
