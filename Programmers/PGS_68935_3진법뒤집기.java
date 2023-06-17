
public class PGS_68935_3진법뒤집기 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        StringBuilder sb = new StringBuilder();
	        while(n != 0){
	            sb.append(n%3);
	            n/=3;
	        }
	        String reversed = sb.toString();
	        char[] now = reversed.toCharArray();
	        int size = reversed.length();
	        for(int i=0; i<size; i++){
	            char temp = now[i];
	            if(temp == '0') continue;
	            answer += Math.pow(3, size-i-1)*(temp-'0');
	        }
	        
	        
	        return answer;
	    }
	}
}
