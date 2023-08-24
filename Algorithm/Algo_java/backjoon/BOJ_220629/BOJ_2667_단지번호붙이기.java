package BOJ_220629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int[][] arr;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = temp[j]-'0';
			}
		} // end for : input
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1) {
					int cntnow = 0;
					cntnow++;
					que.clear();
					que.add(new int[] {i,j});
					arr[i][j] = 0;
					while(!que.isEmpty()) {
						int[] now = que.poll();
						for(int k=0; k<4; k++) {
							int nr = now[0] + dr[k];
							int nc = now[1] + dc[k];
							if(nr<0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] == 0) continue;
							arr[nr][nc] = 0;
							cntnow++;
							que.add(new int[] {nr,nc});
						}
					}
					
					ans.add(cntnow);
				} // end if : 1집일 때
			}
		}
		sb.append(ans.size()).append('\n');
		ans.sort(null);
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}
