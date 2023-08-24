
public class PGS_12930_이상한문자만들기 {
	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        String[] strArr = s.split(" ", -1);
	        for(int idx = 0; idx < strArr.length; idx++){
	            String str = strArr[idx];
	            for(int i=0; i<str.length(); i++){
	                char now = str.charAt(i);
	                if(i%2 == 0 && now >= 97 && now < 123){
	                    now -= 32;
	                } else if (i%2 != 0 && now >= 65 && now < 91) {
	                    now += 32;
	                }
	                sb.append(now);
	            }
	            if(idx != strArr.length - 1){
	                    sb.append(" ");    
	            }
	        }
	        String answer = sb.toString();
	        return answer;
	    }
	}
}
