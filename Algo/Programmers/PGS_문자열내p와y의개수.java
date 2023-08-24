
public class PGS_문자열내p와y의개수 {
	class Solution {
	    boolean solution(String s) {
	        char[] strToChr = s.toCharArray();
	        int cntp = 0;
	        int cnty = 0;
	        for(char character : strToChr){
	            if(character == 'p' || character == 'P') cntp++;
	            if(character == 'y' || character == 'Y') cnty++;
	        }
	        boolean answer = (cntp == cnty) ? true : false;

	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("Hello Java");

	        return answer;
	    }
	}
}
