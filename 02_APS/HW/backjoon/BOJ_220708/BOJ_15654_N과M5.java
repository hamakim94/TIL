package BOJ_220708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {
	static int[] num, sel;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		sel(0);
		System.out.println(sb);
	}

	private static void sel(int level) {
		if(level == M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				sel[level] = num[i];
				visited[i] = true;
				sel(level + 1);
				// visited[i] = false;
			}
		}
		
	}
}
