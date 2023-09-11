class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for(int num : nums){
            int cnt = 0;
            while(num != 0){
                num /= 10;
                cnt++;
            }
            if(cnt%2 == 0)
                answer++;
            
        }
        return answer;
    }
}
