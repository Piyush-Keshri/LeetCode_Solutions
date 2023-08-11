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

class Pair{
    
    TreeNode node;
    int indx;
    
    Pair(TreeNode node,int indx){
        this.node = node;
        this.indx = indx;
    }
    
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        int maxWidth = 0;
        if(root == null){
            return maxWidth;
        }
        
        Queue<Pair> q= new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            
            int levelNum = q.size();
            int start = 0;
            int end = 0;
            for(int i=0;i<levelNum;i++){
                
            Pair p = q.poll();
            TreeNode curr = p.node;
            int indx = p.indx;
                
                if(i == 0){
                    start = indx;
                }
                if(i == levelNum-1){
                    end = indx;
                }
                
                if(curr.left != null){
                    q.add(new Pair(curr.left,2*indx));
                }
                
                if(curr.right != null){
                    q.add(new Pair(curr.right,2*indx+1));
                }
            }
            
            maxWidth = Math.max(maxWidth,end-start+1);
            
        }
        
        return maxWidth;
    }
}
























