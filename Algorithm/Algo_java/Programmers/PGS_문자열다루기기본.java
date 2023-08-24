
public class PGS_문자열다루기기본 {
	class Solution {
	    public boolean solution(String s) {
	        
	        if(!(s.length() == 4 || s.length() == 6)) return false;
	        
	        for(int i =0; i< s.length(); i++){
	            char now = s.charAt(i);
	            if(Math.abs(now - '0') > 10) return false;
	           
	        }
	        
	        return true;
	    }
	}
}
