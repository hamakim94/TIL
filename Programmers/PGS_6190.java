
package PGS_220715;

public class PGS_6190 {

	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        // 0의 개수 세기
	        // lottos랑 win_nums랑 맞은 개수 
	        
	        int cntZero = 0;
	        int sameNum = 0;
	        for(int num : lottos){
	            if(num == 0)cntZero++;
	            for(int winNum : win_nums){
	                if(winNum == num) sameNum++;
	            }
	        }
	        int maxAns = cntZero + sameNum;
	        int minAns = sameNum;
	        int[] answer = {cntNum(maxAns), cntNum(minAns)};
	        return answer;
	    }
	    public int cntNum(int num){
	        if(num == 6){
	            return 1;
	        } else if (num == 5){
	            return 2;
	        }else if (num == 4){
	            return 3;
	        }else if (num == 3){
	            return 4;
	        }else if (num == 2){
	            return 5;
	        } else{
	            return 6;
	        }
	    }
	}
}
