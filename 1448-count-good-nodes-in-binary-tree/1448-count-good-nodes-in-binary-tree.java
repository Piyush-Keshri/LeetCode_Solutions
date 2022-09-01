
class Solution {
    int good;
    
    public int goodNodes(TreeNode root) {    
        
        good = 0;
        preorder(root,Integer.MIN_VALUE);
        return good;
    }
    
    public void preorder(TreeNode root,int max){
        
        if(root == null){
            return;
        }
        
        if(root.val>= max) good++;
        
        max = Math.max(root.val,max);
        
        preorder(root.left,max);
        preorder(root.right,max);
    }
    
}