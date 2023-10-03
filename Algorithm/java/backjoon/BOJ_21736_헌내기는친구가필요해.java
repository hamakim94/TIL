import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char input = arr[j];
                map[i][j] = input;
                if (input == 'I') {
                    startRow = i;
                    startCol = j;
                }
            }
        } // end input

        int ans = BFS(startRow, startCol, map, visited, N, M);
        if(ans == 0){
            System.out.println("TT");
        } else{
            System.out.println(ans);
        }

    }

    private static int BFS(int startRow, int startCol, int[][] map, boolean[][] visited, int row, int col) {

        int answer = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] || map[nr][nc] == 'X') continue;
                visited[nr][nc] = true;
                queue.add(new Pos(nr, nc));
                if(map[nr][nc] == 'P') answer++;
            }
        }

        return answer;

    }

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
