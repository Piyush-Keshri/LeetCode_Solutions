class Solution {

    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        preOrder(root);
        return sb.toString();
        
    }
    
    public void preOrder(TreeNode root){
        
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            
            sb.append(root.val);
            return;
        }
        
        sb.append(root.val);
        sb.append('(');
        preOrder(root.left);
        sb.append(')');
        
        if(root.right != null){
           
            sb.append('(');
            preOrder(root.right);
            sb.append(')');
        } 
        return;
    } 
    
}