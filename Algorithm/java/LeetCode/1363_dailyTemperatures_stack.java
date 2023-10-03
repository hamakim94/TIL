class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--){
            // find the bigone 
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i] = stack.peek() - i;
            }
            stack.push(i);

        }
        return ans;
        
    }
}
