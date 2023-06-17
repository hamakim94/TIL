import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2468_안전영역 {

    static int N; // 크기
    static int[][] map; // 지도
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxHeight = -1;
    static int ans = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        } // end input

        // 이제, 1부터 최대높이까지 BFS돌거야
        // 높이 1씩 빼주고,
        for (int h = 1; h < maxHeight; h++) {


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j]--;
                }
            } // 1 뺐어

            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        visited[i][j] = true;
                        Queue<int[]> que = new LinkedList<>();
                        que.add(new int[]{i, j});
                        while (!que.isEmpty()) {
                            int[] now = que.poll();
                            for (int k = 0; k < 4; k++) {
                                int nr = now[0] + dr[k];
                                int nc = now[1] + dc[k];
                                if (nr < 0 || nr >= N || nc < 0 || nc >= N ||visited[nr][nc]||map[nr][nc] <= 0) continue;
                                visited[nr][nc] = true;
                                que.add(new int[]{nr, nc});
                            }
                        }
                        cnt++;

                    } else {
                        visited[i][j] = true;
                    }
                } // end for : 전체 다 돌았음
            } // 1 뺐어
            ans = Math.max(cnt, ans);
        }
        System.out.println(ans);

    }
}
