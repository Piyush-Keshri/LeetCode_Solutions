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
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> ls = new ArrayList<>();
        
        inorder(root,ls);
        
        return ls.get(k-1);
        
    }
    
    public void inorder(TreeNode root,List<Integer> ls){
        
        if(root == null){
            return;
        }
        
        inorder(root.left,ls);
        
        ls.add(root.val);
        
        inorder(root.right,ls);
        
    } 
    
}