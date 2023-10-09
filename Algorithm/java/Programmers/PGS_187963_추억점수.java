import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        // 1. map 만들기 (name : yearning)
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        // 2. 각 photo for문 돌면서, 
        for(int i=0; i<photo.length; i++){
            String[] now = photo[i];
            // 있으면 점수 더하고 없으면 점수 XX
            int ans = 0;
            for(String temp : now){
                if(map.containsKey(temp)){
                    ans += map.get(temp);
                } 
            }
            answer[i] = ans;
        
        }
        return answer;
    }
}
