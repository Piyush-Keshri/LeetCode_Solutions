
class Solution {
    
    char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    String smallest = "zzzzzzzzzzzzzzzzzzzzzzzzzz";
    
    public String smallestFromLeaf(TreeNode root) {
        solve(root,"");
        return smallest;
    }
        
    public void solve(TreeNode root,String curr){
        
        if(root == null){
            return;
        }
        
        curr = alpha[root.val]+curr;
        
        if(root.left == null && root.right == null){
            
            smallest = curr.compareTo(smallest) < 0 ? curr:smallest;
            
        }
        solve(root.left,curr);
        solve(root.right,curr);
    }

}

