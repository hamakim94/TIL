import java.util.*;



class PGS_다단계칫솔판매 {

    Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], i);
        }

        for(int i=0; i<amount.length; i++){
            caculate( enroll[map.get(seller[i])], amount[i]*100, enroll, referral, answer);
        }

        return answer;
    }

    void caculate(String seller, int profit, String[] enroll, String[] referral, int[] answer){
        // base case
        if(seller.equals("-") || profit == 0) return;
        // recursive case
        int upperProfit = profit / 10;
        int realProfit = profit - upperProfit;
        int nowIdx = map.get(seller);
        answer[nowIdx] += realProfit;
        caculate(referral[nowIdx], upperProfit, enroll, referral, answer);
    }
}