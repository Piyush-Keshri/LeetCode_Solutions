
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      
        ArrayList<Integer> ls1 = new ArrayList<Integer>();
        ArrayList<Integer> ls2 = new ArrayList<Integer>();
        
        inorder(root1,ls1);
        inorder(root2,ls2);
        
        return ls1.equals(ls2);
        
    }
    
    public void inorder(TreeNode root,ArrayList<Integer>ls){
        
        if(root == null){
            return;
        }        
        
        inorder(root.left,ls);
        if(root.left == null && root.right == null){
            ls.add(root.val);
        }
        inorder(root.right,ls);
    }
    
}