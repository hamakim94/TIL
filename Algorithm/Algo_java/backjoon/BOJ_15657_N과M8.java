import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_N°úM8 {
		static int N, M;
		static int[] sel;
		static int[] numArr;
		static StringBuilder sb = new StringBuilder();
		
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
			perm(0);
			System.out.println(sb.toString());
			
		}
		static void perm(int level) {
			// base case
			if(level == M) {
				for(int i : sel) {
					sb.append(i).append(' ');
				}
				sb.append('\n');
				return;
			}
			
			for(int i=0; i<N; i++) {
				if(level == 0) {
					sel[level] = numArr[i];
					perm(level + 1);
				} else {
					if(sel[level-1] <= numArr[i] ) {
						sel[level] = numArr[i];
						perm(level + 1);
					}
				}
				
			}
		}


}
