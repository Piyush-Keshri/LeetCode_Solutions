/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        return solve(root);
        
    }
    
    public int solve(TreeNode root){
        
        int cnt = 0;
        
        if(root  == null){
            return 0;
        }
        
        int lh = 1+solve(root.left);
        int rh = 1+solve(root.right);
        
       return cnt = Math.max(lh,rh);
        
    }
    
}