import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산2 {

    static int ans = -1;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 가족의 수
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작점
        int end = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(br.readLine());
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());
            arr[parent].add(son);
            arr[son].add(parent);
        }
        DFS(start, end, 0);
        System.out.println(ans);

    }

    public static void DFS(int start, int end, int cnt) {
        if (start == end) {
            ans = cnt;
            return;
        }
        visited[start] = true;
        for (int to : arr[start]) {
            if (visited[to]) continue;
            DFS(to, end, cnt + 1);
        }
    }
}
