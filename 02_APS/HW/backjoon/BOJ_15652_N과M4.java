import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4 {
	static int N, M;
	static int[] sel; // 선택된 숫자들
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		perm(0,0);
		System.out.println(sb.toString());
	}
	static void perm(int level, int now) {
		// base case
		if(level == M) {
			for(int num : sel) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		} 
		// recursive case
		for(int i=0; i<N; i++) {
			if( i+1 >= now) {
				sel[level] = i+1;
				perm(level+1, i+1);
			}
		}
	}
}
