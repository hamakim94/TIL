class Solution {
    public int[] solution(int[] sequence, int k) {
        
        
        int N = sequence.length;
        int[] answer = new int[] {0, N-1};
        int left = 0, right = 1;
        int sum = sequence[0];
        
        while(left < right){
            if(sum == k){
                change(right, left, answer);
                sum -= sequence[left++];
            } else if (sum > k){
                sum -= sequence[left++];
            } else if(  right < N){
                sum += sequence[right++];
            } else{
                break;
            }
        }
        
        
        return answer;
    }
    void change(int right, int left, int[] answer){
        if(right - left - 1 < answer[1] - answer[0]){
            answer[0] = left;
            answer[1] = right-1;
        }
    }
}
