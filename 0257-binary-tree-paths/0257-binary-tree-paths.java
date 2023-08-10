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
    public List<String> binaryTreePaths(TreeNode root) {
     
        List<String> ls = new ArrayList<>();
        String path = "";
        solve(root,ls,path);
        return ls;
        
    }
    
    public void solve(TreeNode root,List<String>ls,String path){
        
        if(root == null){
        return ;
        }
        if(root.left == null && root.right == null){
            ls.add(path+root.val);
            path = "";
            return;
        }
        
        path += root.val+"->";
        solve(root.left,ls,path);
        solve(root.right,ls,path);
        
    }
    
}