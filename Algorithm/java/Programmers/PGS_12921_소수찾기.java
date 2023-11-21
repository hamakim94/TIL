class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isNotPrime = new boolean[n+1];
        for(int i=2; i * i <= n; i++){
            if(!isNotPrime[i]){
                int temp = i*i;
                while(temp <= n){
                    isNotPrime[temp] = true;
                    temp += i;
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(!isNotPrime[i]){
                answer++;
            }
        }
        return answer;
    }
}
