
public class PGS_������ڰ������� {
	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        int len = s.length();
	        int middleIdx = len / 2;
	        if(len%2 == 0){
	            sb.append(s.charAt(middleIdx-1));
	            sb.append(s.charAt(middleIdx));
	        } else{
	            sb.append(s.charAt(middleIdx));
	        }
	        return sb.toString();
	    }
	}
}
