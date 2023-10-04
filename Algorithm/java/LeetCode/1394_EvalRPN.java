class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> oper = new Stack<>();
        int ans = 0;
        for(String token : tokens){
            if(token.equals("*")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num1*num2);
            } else if (token.equals("/")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2/num1);
            } else if (token.equals("+")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2+num1);
            } else if (token.equals("-")){
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(num2-num1);
            }else{
                nums.push(Integer.parseInt(token));
            }
        }
        ans = nums.pop();
        return ans;
    }
}
