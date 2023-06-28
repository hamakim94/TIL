import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int n, m;

    static int[][] answer, map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startRow = -1;
        int startCol = -1;

        visited = new boolean[n][m]; // 방문처리
        map = new int[n][m]; // 지도
        answer = new int[n][m]; // 정답
        for(int r=0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<m; c++){
                int now = Integer.parseInt(st.nextToken());
                map[r][c] = now;
                if(now == 0){
                    visited[r][c] = true;
                } else if(now == 2){
                    startRow = r;
                    startCol = c;
                }
            }
        } // end input

        BFS( new Pos(startRow, startCol, 0));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]){
                    sb.append(answer[i][j]).append(' ');
                } else{
                    sb.append(-1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);



    }

    private static void BFS(Pos pos) {

        visited[pos.r][pos.c] = true;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(pos);
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            for(int i=0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] <= 0 ||  visited[nr][nc]) continue;
                visited[nr][nc] = true;
                answer[nr][nc] = now.val + 1;
                queue.add(new Pos(nr, nc, now.val + 1));
            }
        }

    }

    static class Pos {
        int r;
        int c;
        int val;

        public Pos(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }

    }
}
