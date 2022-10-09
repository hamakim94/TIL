import java.util.*;
public class PGS_12981_영어끝말잇기 {
	
	class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        
	        int len = words.length;
	        HashSet<String> set = new HashSet<>();

	        for(int i=0; i<len; i++){
	            if(!set.contains(words[i])){
	                set.add(words[i]);
	            } else{
	                answer[0] = i%n + 1;
	                answer[1] = i/n + 1;
	                return answer;
	            }
	            
	            
	            // prev : 이전 사람이 불렀던 마지막 단어
	            if(i != 0){
	                if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
	                    answer[0] = i%n + 1;
	                    answer[1] = i/n + 1;
	                    break;
	                } 
	            }
	        }

	        return answer;
	    }
	}
}
