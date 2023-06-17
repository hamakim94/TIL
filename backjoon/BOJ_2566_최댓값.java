package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int maxi = -1;
		int row = -1;
		int col = -1;
		int[][] arr = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now > maxi) {
					maxi = now;
					row = i + 1;
					col = j + 1;
				}
			}
		}
		System.out.println(maxi);
		System.out.println(String.format("%d %d", row, col));
	}
}
