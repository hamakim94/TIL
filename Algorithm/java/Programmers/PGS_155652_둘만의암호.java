import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] alphabet = new boolean[26];
        char[] toSkip = skip.toCharArray();
        char[] toGo = s.toCharArray();
        Set<Character> set = new HashSet<>();
        String answer = "";
        
        for(char now : toSkip){
            set.add(now);
        }
        
        for (char now : toGo){
            int num = now;
            for(int i=1; i<=index; i++){
                while(set.contains((char) ((num + 1 > 'z') ? num + 1 - 26 : num + 1))){
                    num = (num + 1 > 'z') ? num + 1 - 26 : num + 1;
                }
                num = (num + 1 > 'z') ? num + 1 - 26 : num + 1;
                
            }
            answer += (char) num;
            
        }
       
           
        
        
        return answer;
    }
}
