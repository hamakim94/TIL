import java.util.*;

public class PGS_1844_게임맵최단거리 {

    class Solution {

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int answer = 0;

        class Node{
            int r;
            int c;
            int count;

            public Node(int r, int c, int count){
                this.r = r;
                this.c = c;
                this.count = count;
            }
        }

        public int solution(int[][] maps) {
            BFS(maps);
            return answer;
        }

        public void BFS(int[][] maps){
            int rowNum = maps.length;
            int colNum = maps[0].length;
            boolean[][] visited = new boolean[rowNum][colNum];
            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(0,0,1));
            visited[0][0] = true;

            while(!queue.isEmpty()){
                Node now = queue.poll();
                for(int i=0; i<4; i++){
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if(nr < 0 || nr >= rowNum || nc < 0 || nc >= colNum || maps[nr][nc] == 0 || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if(nr == rowNum - 1 && nc == colNum - 1){
                        answer = now.count + 1;
                        return;
                    }
                    queue.add(new Node(nr, nc, now.count + 1));
                }
            } // while
            answer = -1;
            return;

        } // bfs


    }
}
