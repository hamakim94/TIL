
public class PGS_�����ѱݾװ���ϱ� {
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
