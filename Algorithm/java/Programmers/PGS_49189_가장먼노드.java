import java.util.*;
public class PGS_49189_가장먼노드 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution = " + solution.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Solution {
        public int solution(int n, int[][] edge) {
            // 1번 노드에서 가장 멀리 떨어진 노드의 개수.
            // 다익스트라 알고리즘을 써서, 시작점과 끝 점의 개수를 구해야 할 듯 싶다
            // for문이 끝나면, 가장 긴 거의 개수를 찾으면 끝.
            boolean[] visited = new boolean[n+1];
            int[] dist = new int[n+1];
            Arrays.fill(dist, 20000000);
            // 시작점 위치 고정
            dist[1] = 0;
            Queue<Integer> toGo = new LinkedList<>();

            // 인접 리스트로 풀어보자
            List<Integer>[] arr = new List[n+1];
            for(int i=1; i<=n; i++){
                arr[i] = new ArrayList<>();
            }
            for(int i=0; i< edge.length; i++){
                int start = edge[i][0];
                int end = edge[i][1];
                arr[start].add(end);
                arr[end].add(start);
            }

            int answer = 0;
            toGo.offer(1);
            visited[1] = true;
            for(int k=0; k<n; k++){
                int now = toGo.poll();
                for(int i : arr[now]){
                    if(visited[i]) continue;
                    if(dist[i] > dist[now] + 1){
                        dist[i] = dist[now] + 1;
                        visited[i] = true;
                        toGo.offer(i);
                    }
                }
            }
            int maxi = 0;
            for(int i=1; i <= n; i++){
                maxi = Math.max(maxi, dist[i]);
            }
            for(int i=1; i <= n; i++){
                if(dist[i] == maxi){
                    answer++;
                }

            }



            return answer;
        }
    }
}
