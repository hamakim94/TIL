package BOJ_220620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	
	static int ans;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			ans = Integer.parseInt(br.readLine());
			cnt = 0;
			DFS(0);
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
		
	}

	private static void DFS(int sum) {
		// TODO Auto-generated method stub
		if(sum > ans)
			return;
		if(sum == ans) {
			cnt++;
			return;
		}
		else {
			DFS(sum + 1);
			DFS(sum + 2);
			DFS(sum + 3);
		}
	
		
	}
}
