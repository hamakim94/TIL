import java.util.Arrays;

public class PGS_12982_¿¹»ê {
	class Solution {
	    public int solution(int[] d, int budget) {
	        int answer = 0;
	        int sum = 0;
	        Arrays.sort(d);
	        for(int num : d){
	            if(sum + num <= budget){
	                sum += num;
	                answer++;
	                continue;
	            } 
	            break;
	        }
	        return answer;
	    }
	}
}
