class Solution{
    public boolean isValidBST(TreeNode root){
        return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validBST(TreeNode root,long minVal,long maxVal){
        if(root == null){
            return true;
        }
        if(root.val<= minVal || root.val>=maxVal){
            return false;
        }
        return validBST(root.left,minVal,root.val) && validBST(root.right,root.val,maxVal);
    }
}