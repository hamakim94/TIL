
public class PGS_부족한금액계산하기 {
	class Solution {
	    public long solution(int price, int money, int count) {
	        long sumPrice = 0;
	        for(int i=1; i<=count; i++){
	            sumPrice += (long) price*i;
	        }
	        return (money - sumPrice) < 0 ? sumPrice - money : 0;
	    }
	}
}
