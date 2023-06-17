
public class PGS_두정수사이의합 {
	class Solution {
	    public long solution(int a, int b) {
	        
	        if(a == b) return a;
	        
	        long answer = 0;
	        int start = 0;
	        int end = 0;
	        if(a>b){
	            start = b;
	            end = a;
	        } else{
	            start = a;
	            end = b;
	        }
	        for(int num=start; num <= end; num++){
	            answer += (long)num;
	        }
	        
	        return answer;
	    }
	}
}
