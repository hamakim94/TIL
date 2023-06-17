import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회 {
    static int N; // size
    static boolean[] visited; // 방문
    static int[][] map; // 비용 지도
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            visited[i] = true;
            DFS(i,i,0,0);
            visited[i] = false;
        }
        System.out.println(ans);

        // 일단 경우의 수를 굳이 나누자면
        // 1, 2, 3 3가지면
        // 1 -> 2 -> 3 -> 1
        // 1 -> 3 -> 2 -> 1
        // 2, 1, 3, 1
        // 2, 3, 1, 2
        // 3, 1, 2, 3
        // 3, 2, 1, 3 이렇게 경우의 수를 모두 구해서 최소값을 찾는게, 완전탐색이지만 빠르다고 생각한다.
        // 갈 수 없는 경우가 또 생기므로, DFS 함 더 돌아야 할듯..!?

    }
    static void DFS(int start, int now, int sum, int cnt){
        if(cnt == N-1){
            if(map[now][start] > 0){
                ans = Math.min(ans, sum + map[now][start]);
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(map[now][i] > 0 && !visited[i]){
                visited[i] = true;
                DFS(start, i, sum + map[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
}
