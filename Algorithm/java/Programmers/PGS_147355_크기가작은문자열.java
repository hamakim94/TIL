class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tl = t.length(); // t가 전체
        int pl = p.length();
        long part = Long.parseLong(p);
        
        for(int i=0; i<tl - pl + 1; i++){
            String temp = t.substring(i, i+pl);
            if(Long.parseLong(temp) <= part) answer++;
        }
        
        return answer;
    }
}
