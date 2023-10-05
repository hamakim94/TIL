class Solution {
    List<Integer> answer = new ArrayList<>();
        
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return answer;
    }
    
    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        answer.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    
        
    }
}
