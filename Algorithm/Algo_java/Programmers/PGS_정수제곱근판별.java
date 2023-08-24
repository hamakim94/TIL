
public class PGS_정수제곱근판별 {
	class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        boolean flag = false;
	        long num = 0;
	        for(long i=1; i <= Math.sqrt(n); i++){
	            if(i*i == n){
	                flag = true;
	                num = i;
	                break;
	            }
	        }
	        if(flag){
	            answer = (num+1) * (num+1);
	        } else{
	            answer= -1;
	        }
	        return answer;
	    }
	}
}
