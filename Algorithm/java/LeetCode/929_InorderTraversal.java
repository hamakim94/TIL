class Solution {
    List<Integer> answer = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return answer;
    }
    
    void inOrder(TreeNode node){
        if(node == null) return;
        
        inOrder(node.left);
        answer.add(node.val);
        inOrder(node.right);
    }
}
