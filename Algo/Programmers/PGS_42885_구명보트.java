	import java.util.Arrays;
public class PGS_42885_구명보트 {

	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int minIdx = 0;
	        for(int maxIdx = people.length - 1; minIdx <= maxIdx; maxIdx--){
	            if(people[maxIdx] + people[minIdx] <= limit){
	                answer++;
	                minIdx++;
	            } else{
	                answer++;
	            }
	        }
	        // 최솟값 구하기
	        // 무게 제한 있을 때;
	        // minIdx, maxIdx를 두고,
	        // 해당 합이 100보다 작으면, answer++
	        // minIdx++ maxIdx --
	        // 만약 해당 합이 100보다 크면,
	        // answer++
	        // minIdx 그대로
	        
	        return answer;
	    }
	}
}
