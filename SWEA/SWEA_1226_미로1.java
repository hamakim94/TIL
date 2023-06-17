import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226_¹Ì·Î1 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Now{
		int r;
		int c;
		
		Now(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			
			int test = Integer.parseInt(br.readLine());
			char[][] map = new char[100][100];
			for(int i=0; i<100; i++) {
				map[i] = br.readLine().toCharArray();
			}// end input
			Queue<Now> que = new LinkedList<>();
			int answer = 0;
			que.add(new Now(1,1));
			outer : while(!que.isEmpty()) {
				Now now = que.poll();
				for(int i=0; i<4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					if(map[nr][nc] == '0') {
						que.add(new Now(nr,nc));
						map[nr][nc] = 1;
					}
					if(map[nr][nc] == '3') {
						answer =1;
						break outer;
					}
				}
				
			} // end while
			System.out.println("#" + tc + " " + answer);
			
			
			
			
		} // end testCase
	}
}
