import java.util.*;

public class PGS_43162_네트워크 {

    class Solution {

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int answer = 0;
        boolean[] visited;

        public int solution(int n, int[][] computers) {
            visited = new boolean[n];
            check(n, computers);
            // 네트워크의 개수를 구하는 문제.
            // 하나에서 BFS 돌리고
            // for문 돌려서 방문처리 안 했으면 주욱 돌리는 식으로 해야할듯.!

            return answer;
        }

        public void check(int n, int[][] computers){
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    answer++;
                    BFS(n, computers, i);
                }
            }
        }
        public void BFS(int n, int[][] computers, int num){
            Queue<Integer> queue = new LinkedList<>();
            visited[num] = true;
            queue.offer(num);
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int i=0; i<n; i++){
                    if(visited[i] || computers[now][i] == 0) continue;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
