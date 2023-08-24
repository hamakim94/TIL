import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_N과M6 {
	static int[] sel; // 뽑는 배열
	static int[] numArr; // 숫자를 가지고 있는 배열
	static int N, M; // 각 N개의 수 중, M개를 뽑아 수열로, 조건은 오름차순! 서로 다름!
	static StringBuilder sb = new StringBuilder(); // 결과를 저장할 값!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		numArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		perm(0, 0);
		System.out.println(sb.toString());
	}
	
	static void perm(int level, int startIdx) {
		// base case
		if(level == M) {
			for(int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		// recusive case
		for(int i=startIdx; i<N; i++) {
			sel[level] = numArr[i];
			perm(level + 1, i+1);
			
		}
	}
	
}
