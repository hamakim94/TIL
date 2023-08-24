import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_���� {
	static int N, M;
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ans = 0;
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(checkOne(map) == 1) {
				ans++;
				nextYear();
//				for(int i=0; i<N; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
				continue;
			} else if (checkOne(map) >= 2) {
				break;
			} else {
				ans = 0;
				break;
			
				
			}
			
			
			
		}
		
		System.out.println(ans);
		// 3�ܰ�� �����ؾ��ҵ�
		// 1. BFS ���鼭 ���� ���� Ȯ��(visited �迭 �ʿ�)
		// 2. 1����� ���ο� �迭 ����, �����¿� ���鼭 (0���� ũ��, �ֺ���0�̸� ���� ����
		// 3. ��ü ��� �߰��ϰ�, �迭 �ֽ�ȭ
		
	}
	// ��ü�� 0���� Ȯ���ϴ� �Լ�
	// ���� ������ ���� ������ִ� �Լ�
	static void nextYear() {
		int[][] newArr = new int[N][M];
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<M-1; c++) {
				if(map[r][c] > 0) {
					int melt = 0;
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(map[nr][nc] <= 0) {
							melt++;
						}
					}
					newArr[r][c] = melt;
				}
			}
		}// end for
		
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<M-1; c++) {
				map[r][c] = map[r][c] - newArr[r][c] > 0 ? map[r][c] - newArr[r][c] : 0;
			}
		}
		
	}
	
	
	// ���� 1������ Ȯ���ϴ� �Լ�
	static int checkOne(int[][] arr) {
		int cnt = 0;
		visited = new boolean[N][M];
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<M-1; c++) {
				if(arr[r][c] > 0 && !visited[r][c]) {
					cnt++;
					visited[r][c] = true;
					que = new LinkedList<>();
					que.add(new int[] {r,c});
					while(!que.isEmpty()) {
						int[] now = que.poll();
						for(int i=0; i<4; i++) {
							int nr = now[0] + dr[i];
							int nc = now[1] + dc[i];
							if(visited[nr][nc] || arr[nr][nc] <= 0) continue;
							visited[nr][nc] = true;
							que.add(new int[] {nr,nc});
							
						}
					} // end BFS;
					
				}
			}
		} // end for 
		return cnt;
	}
}
