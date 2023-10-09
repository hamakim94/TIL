import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String, int[]> map = new HashMap<>();
        map.put("E", new int[] {0,1});
        map.put("W", new int[] {0,-1});
        map.put("S", new int[] {1,0});
        map.put("N", new int[] {-1,0});
        
        int[] answer = {0,0};
        int R = park.length;
        int C = park[0].length();
        
        char[][] arr = new char[R][C];
        for(int r=0; r<R; r++){
            arr[r] = park[r].toCharArray();
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(arr[r][c] == 'S'){
                    answer[0] = r;
                    answer[1] = c;
                }
            }
        }
        
        for(String route : routes){
            String[] now = route.split(" ");
            String direction = now[0];
            int toGo = Integer.parseInt(now[1]);
                
            int[] temp = new int[2];
            temp[0] = answer[0];
            temp[1] = answer[1];
            
            boolean flag = true;
            for(int i=0; i<toGo; i++){
                temp[0] += map.get(direction)[0];
                temp[1] += map.get(direction)[1];
                if(temp[0] < 0 || temp[0] >= R || temp[1] < 0 || temp[1] >= C || arr[temp[0]][temp[1]] == 'X' ){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer[0] = temp[0];
                answer[1] = temp[1];
            }
        }
        return answer;
    }
}
