package BOJ_220709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	static int[][] comb;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			// 뒤에서 앞에걸 뽑는 경우의 수
			comb = new int[N+1][K+1];
			com(N, K);
			sb.append(comb[N][K]).append('\n');
			
		}
		System.out.println(sb);
	}
	private static int com(int n, int k) {
		if(comb[n][k] != 0) {
			return comb[n][k];
		}
		
		if(k == 0 || k == n || n == 1) {
			comb[n][k] = 1;
			return 1;
		}
		return comb[n][k] = com(n-1, k-1) + com(n-1, k);
		
	}
}
