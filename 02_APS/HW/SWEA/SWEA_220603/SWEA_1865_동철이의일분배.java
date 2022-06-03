import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1865_동철이의일분배 {
	static int N; //
	static double[][] prob; // 확률
	static double max;
	static double[] sel;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			prob = new double[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					prob[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
				}
			} // end input
			max = -1;
			
			// 경우의 수
			findMax(0, 1.0);
			System.out.printf("#%d %.6f\n", t, max);
			
		} // end testcase
		
	}

	private static void findMax(int idx, double now) {
		// prunning
		// now는 곱해질수록 무조건 작아져.
		if (now*100 <= max)
			return;
		// base case
		if (idx == N) {
			if (now*100 > max)
				max = now*100;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				// now *=  이
				visited[i] = true;
				findMax(idx + 1, now * prob[idx][i]/100.0);
				visited[i] = false;
			}
		}
	}
}
