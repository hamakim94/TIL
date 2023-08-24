
public class PGS_콜라츠추측 {
	class Solution {
	    public int solution(long num) {
	        int answer = 0;
	        while(num != 1){
	            answer++;
	            if(answer == 500){
	                return -1;
	            }
	            num = num%2 == 0 ? num/2 : num*3 +1;
	        }
	        return answer;
	    }
	}

}
