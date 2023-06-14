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
    TreeNode prevNode;
    int minval = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        
        solve(root);
        return minval;
    }
    
    public void solve(TreeNode root){
        
        if(root == null){
            return;
        }
        
        solve(root.left);
       
        if(prevNode != null){
            minval =Math.min(root.val-prevNode.val,minval);
        }
        prevNode = root;
        
        solve(root.right);
    }
    
}