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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        
        TreeNode curr = root;
        TreeNode pre = root;
        
        if(curr == null){
            return ls;
        }
        
        while(curr != null){
            
            if(curr.left == null){
                ls.add(curr.val);
                curr = curr.right;
            }
            else{
                pre = curr.left;
                
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right  = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    ls.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ls;
    }
}



















