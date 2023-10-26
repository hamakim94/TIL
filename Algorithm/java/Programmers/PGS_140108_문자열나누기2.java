class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        char temp = s.charAt(0);
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(cnt == 0) temp = c;
            if(c == temp){
                cnt++;
            } else{
                cnt--;
            }
            if(cnt == 0){
                answer++;
            }
        }
        if(cnt > 0) answer++;

        return answer;
    }
}
