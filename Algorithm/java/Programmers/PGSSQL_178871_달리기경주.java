import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<Integer, String> levelName = new HashMap<>();
        HashMap<String, Integer> nameLevel = new HashMap<>();
        
        for(int i=0; i<players.length;i++){
            levelName.put(i, players[i]);
            nameLevel.put(players[i], i);
        }
      
        for(String call : callings){
            int togo = nameLevel.get(call);
            int before = togo - 1;
            String name = levelName.get(before);
            nameLevel.put(name, nameLevel.get(name) + 1);
            nameLevel.put(call, nameLevel.get(call) - 1);
            levelName.put(before, call);
            levelName.put(togo, name);
        }
        
        for(int i=0; i < levelName.size(); i++){
            answer[i] = levelName.get(i);
        }
        return answer;
    }
    
}
