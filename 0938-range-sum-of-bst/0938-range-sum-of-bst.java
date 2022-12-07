class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        inorder(root,ls);
        
        int s = ls.indexOf(low);
        int e = ls.indexOf(high);
        int sum = 0;
        
        for(int i = s;i<=e;i++){
            
            sum+= ls.get(i);
            
        }
        return sum;
    }
    
    public void inorder(TreeNode root,ArrayList<Integer> ls){
        
        if(root== null){
            return;
        }
        
        inorder(root.left,ls);
        ls.add(root.val);
        inorder(root.right,ls);
        
    }
}