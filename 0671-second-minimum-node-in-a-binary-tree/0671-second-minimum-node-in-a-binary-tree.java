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
    public int findSecondMinimumValue(TreeNode root) {
           List<Integer> ls = new ArrayList<>();
        
        inorder(root,ls);
        Collections.sort(ls);
        
        
        int min = ls.get(0);
        int second_min = -1;
        
        for(int i=0;i<ls.size();i++){
            
            if(ls.get(i) > min){
                second_min = ls.get(i);
                break;
            }
            
        }
        return second_min;
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