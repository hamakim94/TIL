
public class PGS_�ڿ���������迭�θ���� {
	class Solution {
	    public int[] solution(long n) {
	        // 10���� ���� �������� 0�� �ƴ� �� ����, �迭�� ����� �߰��ؾ���
	        // �׷� �ϴ� �ڸ����� �Ǵ��ϴ� ���� �ϳ� �ְ�
	        int size = 0;
	        long num = n;
	        while(num > 0){
	                size++;
	                num /= 10;
	            }
	        
	        // �װ� ���� �迭�� ������ ���Ѵ���
	        int[] answer = new int[size];
	        int idx = 0;
	        // �ٽõ��鼭 �迭 ���� ä������
	        num = n;
	        while(num > 0){
	            answer[idx++] = (int) (num%10);
	            num /= 10;
	        }

	        
	        return answer;
	    }
	}
}
