import java.util.Stack;
public class PGS_12973_짝지어제거하기 {
	class Solution{
	    public int solution(String s) {
	        int answer = -1;
	        
	        Stack<Character> stack = new Stack<>();
	        for(char a : s.toCharArray()){
	            if(stack.isEmpty()){
	                stack.add(a);
	            } else {
	                if(stack.peek() == a){
	                    stack.pop();
	                } else {
	                    stack.add(a);
	                }
	            }
	        }
	        answer = stack.isEmpty() ? 1 : 0;
	        return answer;
	    }
	}
}
