import java.util.*;
public class PGS_정수내림차순으로배치하기 {
	
	class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        String nums = String.valueOf(n);
	        int[] arrNums = new int[nums.length()];
	        for(int i=0; i<nums.length(); i++){
	            arrNums[i] = - (nums.charAt(i) - '0');
	        }
	        Arrays.sort(arrNums);
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<nums.length(); i++){
	            sb.append(-arrNums[i]);
	        }
	        answer = Long.parseLong(sb.toString());
	        return answer;
	    }
	}
}
