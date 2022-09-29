import java.util.Arrays;
public class PGS_12951_JadenCase문자열만들기 {
	
	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        String[] strArr = s.split(" ", -1);
	        // 97 122 , 25
	        for(int i=0; i<strArr.length; i++){
	            char[] charArr = strArr[i].toCharArray();
	            for(int j=0; j<charArr.length; j++){
	                char nowChar = charArr[j];
	                if(j == 0 && nowChar >= 97 && nowChar <= 122  ){
	                    nowChar -= 32;    
	                } else if (j != 0 && nowChar >= 65 && nowChar <= 90 ){
	                    nowChar += 32;
	                }
	                sb.append(nowChar);               
	            } // end for : str
	            if(i == strArr.length - 1) break;
	            sb.append(' ');
	        }
	        return sb.toString();
	    }
	}
}
