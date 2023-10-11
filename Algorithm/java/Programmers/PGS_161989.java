import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = section[0];
        for(int now : section){
            if( now < start ) continue;
            answer++;
            start = now + m;
        }
        return answer;
    }
}
