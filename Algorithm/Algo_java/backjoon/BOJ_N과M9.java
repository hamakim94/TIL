import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_N°úM9 {
	static int N, M;
	static int[] numArr;
	static int[]sel;

	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		numArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N];
		Arrays.sort(numArr);
		perm(0);
		System.out.println(sb.toString());
	}
	static void perm(int level) {
		// base case
		if(level == M) {
			for(int num : sel) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		int before = 0;
		
		// recursive case
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			System.out.println(before);
			if(before == numArr[i]) continue;
			
			visited[i] = true;
			sel[level] = numArr[i];
			before = numArr[i];
			perm(level + 1);
			visited[i] = false;
		
		}
		
	}
}
