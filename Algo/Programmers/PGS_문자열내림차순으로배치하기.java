import java.util.Arrays;

public class PGS_���ڿ������������ι�ġ�ϱ� {

	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        // charAt�� �̿��ؼ� ���ο� �迭�� �����
	        // ���� �迭 �����
	        // '0'�� ���� ���� �����
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
