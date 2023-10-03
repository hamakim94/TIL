
public class PGS_³»Àû {

	class Solution {
	    public int solution(int[] a, int[] b) {
	        int len = a.length;
	        int answer = 0;
	        for(int i=0; i<len; i++){
	            answer += a[i]*b[i];
	        }
	        return answer;
	    }
	}
}
