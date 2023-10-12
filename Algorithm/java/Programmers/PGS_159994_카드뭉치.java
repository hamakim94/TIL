class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        // 투 포인터를 사용하자
        // 왼쪽 l, 오른쪽 r 해서
        // g : l + r 길이만큼해서
        // 왼 오 비교하고 없으면 그냥 out
        // 왼쪽 : l++, 다시 비교
        // 으론쪽 : r++ 다시 비교
        int l = 0;
        int r = 0;
        int g = 0;
        while(g < goal.length) {
            if(l < cards1.length && goal[g].equals(cards1[l])){
                l++;
                g++;
            } else if (r < cards2.length && goal[g].equals(cards2[r])){
                r++;
                g++;
            } else{
                return "No";
            }
        }
        
        return "Yes";
    }
}
