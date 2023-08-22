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
    int cnt,ans;
    public int kthSmallest(TreeNode root, int k) {
        
        cnt = 0;
        ans = -1;
        
        return inorder(root,k);
        
    }
    
    public int inorder(TreeNode root,int k){
        
        if(root == null){
            return 0;
        }
        
        inorder(root.left,k);
        cnt++;
        if(cnt == k){
            ans = root.val;
        }
        inorder(root.right,k);
    
        return ans;
    }
    
}