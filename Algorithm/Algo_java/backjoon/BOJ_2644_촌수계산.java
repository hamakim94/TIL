import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[101][101];
        // 가족의 수
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작점
        int end = Integer.parseInt(st.nextToken());
        int ans = 1;
        int line = Integer.parseInt(br.readLine());
        boolean flag = false;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            map[parent][son] = 1;
            map[son][parent] = 1;
        }
        boolean[] visited = new boolean[101];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        outer : while (!que.isEmpty()) {

            int size = que.size();
            for (int i = 0; i < size; i++) {

                int now = que.poll();
                for (int j = 1; j < 101; j++) {
                    if (map[now][j] == 1 && !visited[j]) {
                        if (j == end) {
                            flag = true;
                            break outer;
                        }
                        visited[j] = true;
                        que.add(j);
                    }
                }
            }
            ans++;

        } // end while
        if (flag) {
            System.out.println(ans);
        } else {
            System.out.println("-1");
        }


    }
}
