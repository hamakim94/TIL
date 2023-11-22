class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {0,1,2,3,4};
        int[] person2 = {1,0,1,2,1,3,1,4};
        int[] person3 = {2,2,0,0,1,1,3,3,4,4};
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        int i =0;
        int ans = 0;
        while(i < answers.length){
            
            if(person1[i%5] == answers[i]-1) cnt1++;
            if(person2[i%8] == answers[i]-1) cnt2++;
            if(person3[i%10] == answers[i]-1) cnt3++;
            i++;
            ans = (ans + 1) % 5;
        }
        int maxi = Math.max(cnt1, cnt2);
        int maxx = Math.max(maxi, cnt3);
        
        if(cnt1 == cnt2 && cnt2 == cnt3){
            answer = new int[] {1,2,3};
        } else if (cnt1 == cnt2 && cnt1 == maxx){
            answer = new int[] {1,2};
        } else if (cnt1 == cnt3 && cnt1 == maxx){
            answer = new int[] {1,3};
        } else if (cnt2 == cnt3 && cnt2 == maxx){
            answer = new int[] {2,3};
        } else {
            if(cnt1 == maxx) answer = new int[] {1};
            if(cnt2 == maxx) answer = new int[] {2};
            if(cnt3 == maxx) answer = new int[] {3};
        }
        
        
        return answer;
    }
}
