
public class PGS_수박수박수박수박수박수 {
	class Solution {
	    public String solution(int n) {
	        StringBuilder sb = new StringBuilder();
	        for(int i=1; i<=n; i++){
	            if(i%2 == 1){
	                sb.append("수");
	            } else{
	                sb.append("박");
	            }
	        }
	        return sb.toString();
	    }
	}
}
