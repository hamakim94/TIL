package BOJ_220707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
	static int[][] arr;
	static int N;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end for : 입력 완료
		
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
			}
		}
		System.out.println(arr[0][0]);
	
	}

}
