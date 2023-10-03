
public class PGS_131705_ªÔ√—ªÁ {
	class Solution {
	    public int solution(int[] number) {
	        int answer = 0;
	        int size = number.length;
	        
	        for(int i=0; i<size - 2; i++){
	            for(int j = i+1; j<size-1; j++){
	                for(int k = j+1; k<size; k++){
	                    if(number[i] + number[j] + number[k] == 0){
	                        answer++;
	                    }
	                }
	            }
	        }
	        return answer;
	    }
	}
}
