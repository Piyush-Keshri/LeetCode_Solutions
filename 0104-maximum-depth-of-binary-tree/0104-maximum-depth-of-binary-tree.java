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
     int cnt = 0;
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
           int size = q.size();
            while(size-->0){
                
            TreeNode curr = q.poll();
            
            if(curr.left!= null){
            q.add(curr.left);
            }
            
            if(curr.right != null){
                q.add(curr.right);
            }
        }
            cnt++;
    }
        
        return cnt;
    }
}