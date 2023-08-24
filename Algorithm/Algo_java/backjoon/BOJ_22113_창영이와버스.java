package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22113_창영이와버스 {
	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] bus = new int[M];
		int[][] price = new int[N][N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			bus[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		for(int i=0; i<M-1; i++) {
			answer += price[bus[i]-1][bus[i+1]-1];
		}
		System.out.println(answer);
	}
}
