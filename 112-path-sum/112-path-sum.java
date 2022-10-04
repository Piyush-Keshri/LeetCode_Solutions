
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
            
        if(root == null){
            return false;
        }
        else
        return(root.left == null && root.right == null && root.val == targetSum) || hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
        
    }
}