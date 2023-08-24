import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_N��M5 {
	static int N, M;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		sel = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb.toString());
		
	}
	public static void perm(int level) {
		// base case
		if(level == M) {
			for(int num : sel) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//recursive case
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			sel[level] = arr[i];
			visited[i] = true;
			perm(level + 1);
			visited[i] = false;
			
		}
	}
}
