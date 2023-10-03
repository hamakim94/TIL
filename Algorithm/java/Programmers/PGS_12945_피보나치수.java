
public class PGS_12945_피보나치수 {
	class Solution {
	    public int solution(int n) {
	        int[] fibo = new int[n+1];
	        fibo[0] = 0;
	        fibo[1] = 1;
	        for(int idx = 2; idx <= n; idx++){
	            fibo[idx] = (fibo[idx-1] + fibo[idx-2])%1234567;
	        }
	        int answer = fibo[n];
	        return answer;
	    }
	}
}
