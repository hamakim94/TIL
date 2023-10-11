import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // key map을 돌면서, 최소 눌러야 하는 횟수를 찾고
        Map<Character, Integer> map = new HashMap<>();
        for(String key : keymap){
            char[] now = key.toCharArray();
            for(int i=0; i<now.length; i++){
                if(!map.containsKey(now[i])){
                    map.put(now[i], i+1);
                } else{
                    map.put(now[i], Math.min(map.get(now[i]), i+1));
                }
            }
        }
        
        // target을 돌면서, 더하고, 없으면 그냥 -1을 넣어야겠네.
        for(int i=0; i<targets.length; i++){
            int ans = 0;
            String now = targets[i];
            for(int j=0; j<now.length(); j++){
                if(map.containsKey(now.charAt(j))){
                    ans += map.get(now.charAt(j));
                } else{
                    ans = -1;
                    break;
                }
                
            }
            answer[i] = ans;
        }
        
        return answer;
    }
}
