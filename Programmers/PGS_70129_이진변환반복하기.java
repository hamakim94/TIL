
public class PGS_70129_이진변환반복하기 {
	static int deleteZeroCnt = 0;
	
	class Solution {   
	    
	    public int[] solution(String s) {
	        int cnt = 0;
	        while(!s.equals("1")){
	            cnt++;
	            s = deleteZero(s);
	            int now = s.length();
	            s = toBinary(now);
	        }
	        int[] answer = {cnt, deleteZeroCnt};
	        return answer;
	    }
	    public String deleteZero(String input){
	        StringBuilder sb = new StringBuilder();
	        char[] arr = input.toCharArray();
	        for(char ch : arr){
	            if(ch == '0'){
	                deleteZeroCnt++;
	                continue;
	            }
	            sb.append(ch);
	        }
	        return sb.toString();
	    }
	    
	    public String toBinary (int n){
	        StringBuilder sb = new StringBuilder();
	        while(n != 0){
	            System.out.println(n%2);
	            sb.append(n%2);
	            n /= 2;
	        }
	        return sb.reverse().toString();
	    }
	}
}
