package BOJ_220628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	static class lo {
		int row;
		int col;
		int cnt;

		lo(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };
		boolean[][] visited = new boolean[N][M]; // 방문처리
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}
		Queue<lo> que = new LinkedList<>();
		que.add(new lo(0,0,1));
		visited[0][0] = true;
		outer : while(!que.isEmpty()) {
			lo now = que.poll();
			for(int i=0; i<4; i++) {
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 0  ) continue;
				if(visited[nr][nc]) continue;
				if(nr == N-1 && nc == M-1) {
					System.out.println(now.cnt + 1);
					break outer;
				}
				visited[nr][nc] = true;
				que.add(new lo(nr,nc,now.cnt+1));
			}
		}
		
	}
}
