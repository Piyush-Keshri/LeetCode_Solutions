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
    public int getMinimumDifference(TreeNode root) {
    
        ArrayList<Integer> ls = new ArrayList<>();
        
        solve(root,ls);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=1;i<ls.size();i++){
            
            minDiff = Math.min(ls.get(i) - ls.get(i-1),minDiff);
            
        }
        return minDiff;
        
    }
    
    public void solve(TreeNode root,ArrayList<Integer> ls){
        
        if(root == null){
            return;
        }
        
        solve(root.left,ls);
        ls.add(root.val);
        solve(root.right,ls);
    }
    
}