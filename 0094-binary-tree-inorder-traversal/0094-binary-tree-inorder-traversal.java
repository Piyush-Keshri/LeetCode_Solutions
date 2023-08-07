class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         
        List<Integer> ls = new ArrayList<>();
        inorder(root,ls);
        return ls;
    }
    
    public void inorder(TreeNode root,List<Integer> ls){
        
        if(root ==null){
            return;
        }
        inorder(root.left,ls); 
        ls.add(root.val);
        inorder(root.right,ls);
        
    }
    
}