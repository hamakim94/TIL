package BOJ_220724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[3][N];
		int[][] minArr = new int[3][N];
		int[][] maxArr = new int[3][N];
		
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[j][i] = temp;
			}
		}
		for(int i=0; i<3; i++) {
			minArr[i][0] = arr[i][0];
			maxArr[i][0] = arr[i][0];
		}
		
		for(int i=1; i<N; i++) {
			minArr[0][i] = arr[0][i] + Math.min(minArr[0][i-1], minArr[1][i-1]);
			minArr[1][i] = arr[1][i] + Math.min(minArr[0][i-1], Math.min(minArr[1][i-1],  minArr[2][i-1]));
			minArr[2][i] = arr[2][i] + Math.min(minArr[1][i-1], minArr[2][i-1]);
			maxArr[0][i] = arr[0][i] + Math.max(maxArr[0][i-1], maxArr[1][i-1]);
			maxArr[1][i] = arr[1][i] + Math.max(maxArr[0][i-1], Math.max(maxArr[1][i-1],  maxArr[2][i-1]));
			maxArr[2][i] = arr[2][i] + Math.max(maxArr[1][i-1], maxArr[2][i-1]);
		}
		
		int maxi = 0;
		int mini = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			maxi = Math.max(maxArr[i][N-1], maxi);
			mini = Math.min(minArr[i][N-1], mini);
		}
		System.out.println(maxi + " " + mini);
		
		
		
		
	}
}
