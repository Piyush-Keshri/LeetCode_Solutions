
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(root!=null){
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
        
    }
}