package PGS_220822;
import java.util.*;

public class PGS_ÆùÄÏ¸ó {

	class Solution {
	    public int solution(int[] nums) {
	        HashSet<Integer> set = new HashSet<>();
	        for(int i:nums){
	            set.add(i);
	        }
	        
	        int answer = set.size();
	        if(answer > nums.length/2){
	            answer = nums.length/2;
	        }
	        return answer;
	    }
	}
}
