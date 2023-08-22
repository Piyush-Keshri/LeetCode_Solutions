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
    int sum;
    
    public boolean isLeaf(TreeNode root){
        
        if(root.left == null && root.right == null){
            return true;
        }
        return false;   
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
       return  inorder(root,false);
    }
    
    public int inorder(TreeNode root,boolean isLeft){
        
        if(root == null){
            return 0;
        }
        
        
        inorder(root.left,true);
        
        if(isLeaf(root) && isLeft){
            sum+=root.val;
        }
        
        inorder(root.right,false);
        
         
        // if(isLeaf(root)){
        //     sum-=root.val;
        // }
        
        return sum;
    }
    
    
}









