import java.util.*;
public class PGS_68644_두개뽑아서더하기 {

	class Solution {
	    public int[] solution(int[] numbers) {
	        
	        HashSet<Integer> set = new HashSet<>();
	        for(int i=0; i<numbers.length - 1; i++){
	            for(int j=i+1; j<numbers.length; j++ ){
	                set.add(numbers[i] + numbers[j]);
	            }
	        }
	        ArrayList<Integer> arr = new ArrayList<>(set);
	        Collections.sort(arr, (a,b) -> a-b);
	        int[] answer = new int[arr.size()];
	        for(int i=0; i<arr.size(); i++){
	            answer[i] = arr.get(i);
	        }

	        
	        return answer;
	    }
	}
}
