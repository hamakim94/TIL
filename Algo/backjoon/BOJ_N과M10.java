import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_N°úM10 {
	static int N,M;
	static int[] numArr;
	static int[] sel;
	static StringBuilder sb = new  StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		numArr = new int[N];
		sel = new int[M];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		perm(0, 0);
		System.out.println(sb);
		
	}
	static void perm(int level, int nowIdx) {
		if(level == M) {
			for(int num : sel) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int before = 0;
		for(int i=nowIdx; i<N; i++) {
			if(before < numArr[i]) {
				before = numArr[i];
				sel[level] = numArr[i];
				perm(level + 1, i+1);
			}
		}
	}
}
