import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 만약 pq의 size가 k보다 작으면 그냥 add
        // pq의 size == k 라면,
        // pq의 최솟값이 현재 score보다 작으면
        // 하나 뽑고 하나 넣고
        // answer에 peek 저장.
            
        for(int i=0; i<score.length; i++){
            if(pq.size() < k){
                pq.add(score[i]);
            } else{
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                }
            }
            answer[i] = pq.peek();
           
        }
        return answer;
    }
}
