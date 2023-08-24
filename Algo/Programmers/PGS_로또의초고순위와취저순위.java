import java.util.*;
public class PGS_로또의초고순위와취저순위 {
	
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        // 당첨 번호 집합
	        HashSet<Integer> set = new HashSet<>();
	        for(int num : win_nums){
	            set.add(num);
	        }
	        // set에 contains 가 돼있다면 cntWin++; 
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
