
public class PGS_���ڿ���p��y�ǰ��� {
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

	        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
	        System.out.println("Hello Java");

	        return answer;
	    }
	}
}
