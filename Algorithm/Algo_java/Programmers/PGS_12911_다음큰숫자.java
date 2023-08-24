
public class PGS_12911_다음큰숫자 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        int cntOne = 0;
	        int cntAns = 0;
	        int nextNum = n;
	        while(true){
	            if(n%2 == 1) cntOne++;
	            n /= 2;
	            if(n == 0) break;
	        }
	        outer : for(int i=nextNum+1; i<=1000000; i++){
	            int tempNum = i;
	            cntAns = 0;
	            while(true){
	                if(tempNum%2 == 1) cntAns++;
	                tempNum /= 2;
	                if(tempNum == 0) break;
	            }
	            if(cntAns == cntOne) {
	                nextNum = i;
	                break outer;
	            }
	        }
	        return nextNum;
	    }
	}
}
