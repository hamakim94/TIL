import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_최소비용구하기 {

    static List<Node>[] list;
    static long[] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        dp = new long[N+1];
        check= new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        } // 인접 배열 만들기 완료

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            
            list[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dp[destination]);

    }

    private static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node node = q.poll(); // Node(1, 0)
            int from = node.to; // 1
            if(check[from]) continue;
            check[from] = true;

            for(Node next : list[from]){ // to : 2, cost : 2
                //    dp[2]       dp[1] + 2
                if(dp[next.to] >= dp[from] + next.cost){
                    dp[next.to] = dp[from] + next.cost;
                    q.add(new Node(next.to, dp[next.to]));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int to;
        long cost;

        public Node(int to, long cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.cost - o.cost);
        }

    }
}
