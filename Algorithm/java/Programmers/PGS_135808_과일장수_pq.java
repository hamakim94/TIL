import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b - a);
        for(int s : score){
            pq.offer(s);
        }
        int boxNum = score.length / m;
        PriorityQueue<Integer> pqScore;
        for(int i=0; i<boxNum; i++){
            pqScore = new PriorityQueue<>();
            for(int j=0; j<m; j++){
                pqScore.offer(pq.poll());
            }
            answer += (m * pqScore.peek());
        }
        
        return answer;
    }
}
