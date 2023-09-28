class Solution {
    public boolean isValid(String s) {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for(char now : input){
            if(now == '(' || now == '[' || now == '{'){
                stack.push(now);
            } else{
                if(stack.isEmpty()) return false;
                int temp = stack.pop();
                if(temp != map.get(now)) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
