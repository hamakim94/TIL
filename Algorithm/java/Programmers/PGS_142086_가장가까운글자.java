class Solution {
    public int[] solution(String s) {
        // 일단 2중 반복문을 돌거구
        int len = s.length();
        int[] answer = new int[len];
        outer : for(int i=0; i<len; i++){
            char temp = s.charAt(i);
             // 2중 반복을 i부터 0까지 돌면서, 자신과 같은 경우는 현재 i 에서 j 빼기
            for(int j=i-1; j >= 0; j--){
                if(s.charAt(j) == temp){
                    answer[i] = i - j;
                    continue outer;       
                }
            }
            // 끝까지 다 돌면 -1 반환
            answer[i] = -1;
            
        }
        return answer;
    }
}
