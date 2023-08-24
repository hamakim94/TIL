import java.util.Arrays;

public class PGS_����������¼��ڹ迭 {
	
	class Solution {
	    public int[] solution(int[] arr, int divisor) {
	        int[] answer = {};
	        Arrays.sort(arr);
	        int divisorCnt = 0;
	        for(int num : arr){
	            if(num % divisor == 0){
	                divisorCnt++;
	            }
	        }
	        if(divisorCnt == 0){
	            answer = new int[] {-1};
	        } else{
	            int newIdx = 0;
	            int[] tempArr = new int[divisorCnt];
	            for(int num : arr){
	                if(num % divisor == 0){
	                    tempArr[newIdx++] =  num;  
	                }
	                
	            }
	            answer = tempArr;
	        }
	        return answer;
	    }
	}
}
