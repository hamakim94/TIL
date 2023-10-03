
public class PGS_자연수뒤집어배열로만들기 {
	class Solution {
	    public int[] solution(long n) {
	        // 10으로 나눈 나머지가 0이 아닐 떄 까지, 배열을 만들고 추가해야해
	        // 그럼 일단 자릿수를 판단하는 숫자 하나 있고
	        int size = 0;
	        long num = n;
	        while(num > 0){
	                size++;
	                num /= 10;
	            }
	        
	        // 그걸 토대로 배열의 사이즈 정한다음
	        int[] answer = new int[size];
	        int idx = 0;
	        // 다시돌면서 배열 원소 채워나가
	        num = n;
	        while(num > 0){
	            answer[idx++] = (int) (num%10);
	            num /= 10;
	        }

	        
	        return answer;
	    }
	}
}
