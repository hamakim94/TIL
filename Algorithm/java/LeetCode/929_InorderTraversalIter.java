class Solution {
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            // 왼쪽으로 계속 감
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            // 이제 왼쪽 null, stack pop()
            curr = stack.pop();
            // 더이상 갈 곳 없으니까, 답에 더해
            ans.add(curr.val);
            // 왼쪽은 이미 다 봤지, curr = right로 하자
            curr = curr.right; // 이제 다시 right부터 왼쪽 가지 있는지 확인

        }
        return ans;
    }
    
}
