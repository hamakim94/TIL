
public class PGS_���ڼ��ڼ��ڼ��ڼ��ڼ� {
	class Solution {
	    public String solution(int n) {
	        StringBuilder sb = new StringBuilder();
	        for(int i=1; i<=n; i++){
	            if(i%2 == 1){
	                sb.append("��");
	            } else{
	                sb.append("��");
	            }
	        }
	        return sb.toString();
	    }
	}
}
