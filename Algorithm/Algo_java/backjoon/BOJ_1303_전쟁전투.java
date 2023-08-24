import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {
    static int N, M;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }
        int[] ans = new int[2];
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!visited[r][c]){
                    Queue<int[]> que = new LinkedList<>();
                    visited[r][c] = true;
                    char start = arr[r][c];
                    que.add(new int[] {r,c});
                    int cnt = 1;
                    while(!que.isEmpty()){
                        int[] now = que.poll();
                        for(int i=0; i<4; i++){
                            int nr = now[0] + dr[i];
                            int nc = now[1] + dc[i];
                            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                            if(arr[nr][nc] == start) {
                                que.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                                cnt++;
                            }

                        }
                    } // end BFS
                    if(start == 'W') {
                        ans[0] += Math.pow(cnt, 2);
                    } else {
                        ans[1] += Math.pow(cnt, 2);
                    }

                }

            }
        } // end for : bfs 완료
        System.out.println(ans[0] + " " + ans[1]);

    }
}
