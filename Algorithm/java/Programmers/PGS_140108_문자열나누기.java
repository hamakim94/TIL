class Solution {
    public int solution(String s) {
        // for문을 2번 돌아보고
        // 바깥 인덱스를 빼볼까
        int answer = 0;
        int len = s.length();
        int same, diff;
        
        a : for(int i=0; i< len; i++){
            char now = s.charAt(i);
            same = 1;
            diff = 0;
            // 안쪽 loop
            if(i == len-1 ) {
                answer++;
                break a;
            }
            
            for(int j=i+1; j<len; j++){
                
                if(s.charAt(j) == now){
                    same++;
                } else {
                    diff++;
                } 
                if(same == diff){
                    // System.out.println(i + " " + j);
                    i += (j-i);
                    answer++;
                    break;
                }
                if(j == len-1 && same != diff) {
                    answer++;
                    break a;
                 }
                

            }
            
            
        }
        return answer;
    }
}
