	import java.util.*;
public class PGS_완주하지못한선수 {

	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        for(String player : participant){
	            if(map.containsKey(player)){
	                map.put(player ,map.get(player) + 1); 
	            } else{
	                map.put(player, 1);
	            }
	        }
	        for(String player : completion){
	            map.put(player, map.get(player) -1);
	        }
	        
	        for( String temp : participant){
	            if(map.get(temp) != 0){
	                answer = temp;
	                break;
	            }
	        }
	        return answer;
	    }
	}
}
