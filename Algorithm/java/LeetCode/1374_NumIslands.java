class Solution {
    
    boolean[][] visited;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    BFS(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }
    void BFS( int r, int c, char[][] grid){
        Queue<Loc> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.offer(new Loc(r,c));
        while(!queue.isEmpty()){
            Loc now = queue.poll();
            for(int i=0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == '0') continue;
                grid[nr][nc] = '0';
                queue.offer(new Loc(nr,nc));
            }
        }
    }
    
    class Loc{
        int r;
        int c;
        
        Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
