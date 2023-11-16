class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 1부터 number까지 반복 돌면서
        for(int num = 1; num <= number; num++){
            int temp = 0;
            // 숫자 : num
            for(int i = 1; i * i <= num; i++){
                if(i * i == num){
                    temp++;
                } else if (num % i == 0){
                    temp += 2;
                }
            }
            if(temp > limit){
                answer += power;
            } else{
                answer += temp;
            }
        }
        return answer;
    }
}
