
import java.util.Arrays;

public class PGS_17681_비밀지도 {

	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        for(int i=0; i<n; i++){
	            String temp = "";
	            String[] strArr = Integer.toString(arr1[i] | arr2[i],2).split("");
	            if(n > strArr.length){
	                for(int j=0; j<n-strArr.length; j++){
	                    temp += " ";
	                }
	            }
	            for(String now : strArr){
	                
	                if(now.equals("1")){
	                    temp += "#";
	                } else{
	                    temp += " ";
	                }
	                
	            }
	            answer[i] = temp;
	        }
	        System.out.println(Arrays.toString(answer));

	        return answer;
	    }
	}
	
	 public String[] solution2(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        for(int i=0; i<n; i++){
	            String binaryStr = Integer.toString(arr1[i] | arr2[i], 2);
	            binaryStr = String.format("%"+n+"s", binaryStr);
	            binaryStr = binaryStr.replaceAll("1", "#");
	            binaryStr = binaryStr.replaceAll("0", " ");
	            answer[i] = binaryStr;
	        }
	        return answer;
	    }
}
