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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        
        
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st1 = new Stack<>();
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null){
            return ans;
        }
        
        st.add(root);
        
        while(st.size() != 0){
            
            TreeNode node = st.pop();
            st1.push(node);
            if(node.left != null){
                st.push(node.left);
            }
            if(node.right != null){
                st.push(node.right);
            } 
        }
        
        while(st1.size() != 0){
            
            ans.add(st1.pop().val);
            
        }
        return ans;
    }
}