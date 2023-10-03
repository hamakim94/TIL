import java.util.Arrays;

public class PGS_문자열내림차순으로배치하기 {

	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        // charAt을 이용해서 새로운 배열을 만들고
	        // 숫자 배열 만든다
	        // '0'을 빼서 숫자 만들고
	        int stringLen = s.length();
	        int[] nums = new int[stringLen];
	        for(int i=0; i<stringLen; i++){
	            nums[i] = s.charAt(i);
	        }
	        Arrays.sort(nums);
	        
	        for(int i=stringLen-1; i>= 0; i--){
	            sb.append((char) nums[i]);
	        }
	        
	        return sb.toString();
	    }
	   
	}
}
