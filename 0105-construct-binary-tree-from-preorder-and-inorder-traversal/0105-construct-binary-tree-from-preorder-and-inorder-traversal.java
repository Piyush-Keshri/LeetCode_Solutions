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
    
    HashMap<Integer,Integer> hm;
    int preindx; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preindx = 0;
//         To store inorder ele and their indx;
        hm = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            
            hm.put(inorder[i],i);
            
        }
        return arrayToTree(preorder,0,preorder.length-1);
        
    }
    
    public TreeNode arrayToTree(int[] preorder,int pos,int poe){
        
        if(pos > poe){
            return null;
        }
        
        int rootVal = preorder[preindx++];
        
        TreeNode root = new TreeNode(rootVal);
        
        root.left = arrayToTree(preorder,pos,hm.get(rootVal)-1);        
        root.right = arrayToTree(preorder,hm.get(rootVal)+1,poe);
        
        return root;
    
    }    
    
}
















