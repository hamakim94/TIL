
public class PGS_ÇÏ»þµå¼ö {
	class Solution {
	    public boolean solution(int x) {
	        boolean answer = true;
	        int spaceSum = 0;
	        int num = x;
	        while(num != 0){
	            spaceSum += num%10;
	            num /= 10;
	        }
	        
	        answer = (x%spaceSum == 0)? true : false;
	        return answer;
	    }
	}
}
