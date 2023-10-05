class Solution {
        
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> togo = new Stack<>();
        togo.add(root);
        while(!togo.isEmpty()){
            TreeNode now = togo.pop();
            if(now != null){
                list.add(now.val);
            }
            if(now.right != null){
                togo.add( now.right);
            } 
            if(now.left != null){
                togo.add(now.left);
            }
            
        }

        return list;
    }
    
}
