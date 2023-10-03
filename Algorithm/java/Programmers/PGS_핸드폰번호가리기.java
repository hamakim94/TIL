
public class PGS_핸드폰번호가리기 {
	class Solution {
	    public String solution(String phone_number) {
	        int size = phone_number.length();
	        StringBuilder sb = new StringBuilder();
	        char[] nums = phone_number.toCharArray();
	        for(int i=0; i<size - 4; i++){
	                sb.append('*');
	        }
	        sb.append(phone_number.substring(size-4));
	        String answer = sb.toString();
	        return answer;
	    }
	}
}
