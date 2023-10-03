import java.util.*;
public class PGS_�ζ����ʰ�������������� {
	
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        // ��÷ ��ȣ ����
	        HashSet<Integer> set = new HashSet<>();
	        for(int num : win_nums){
	            set.add(num);
	        }
	        // set�� contains �� ���ִٸ� cntWin++; 
	        int cntWin = 0;
	        int cntZero = 0;
	        for(int num : lottos){
	            if(set.contains(num)) cntWin++;
	            if(num == 0) cntZero++;
	        }
	        int[] answer = new int[2];
	        answer[0] = 7-cntWin-cntZero== 7 ? 6 : 7-cntWin-cntZero;
	        answer[1] = 7-cntWin == 7 ? 6 : 7-cntWin;
	        return answer;
	    }
	}
}
