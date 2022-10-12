	import java.util.Arrays;
public class PGS_42885_����Ʈ {

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
	        // �ּڰ� ���ϱ�
	        // ���� ���� ���� ��;
	        // minIdx, maxIdx�� �ΰ�,
	        // �ش� ���� 100���� ������, answer++
	        // minIdx++ maxIdx --
	        // ���� �ش� ���� 100���� ũ��,
	        // answer++
	        // minIdx �״��
	        
	        return answer;
	    }
	}
}
