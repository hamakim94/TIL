
public class PGS_12926_시저암호 {
	class Solution {
	    public String solution(String s, int n) {
	        StringBuilder sb = new StringBuilder();
	        for(char now : s.toCharArray()){
	            if( 65 <= now  && now<= 90){
	                if(now + n > 90){
	                    sb.append((char) (now+n-26));
	                } else{
	                    sb.append((char) (now+n));
	                }
	            } else if (97 <= now && now <= 122){
	                if(now + n > 122){
	                    sb.append((char) (now+n-26));
	                } else{
	                    sb.append((char) (now+n));
	                }
	            } else{
	                sb.append(' ');
	            }
	            
	        }
	        return sb.toString();
	    }
	}
}
