import java.util.Arrays;
public class PGS_12941_�ּڰ������ {

	class Solution	{
	    public int solution(int []A, int []B) {
	    	int answer = 0;
	        int[] numArr = new int[A.length];
	        int len = A.length;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        for(int i=0; i<len; i++){
	            answer += A[i]*B[len-1-i];
	        }
	        return answer;
	    }
	}
}
