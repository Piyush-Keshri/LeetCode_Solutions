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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null){
            return ls;
        }        
        st.push(root);
        TreeNode node = root;
        while(!st.isEmpty()){
            
            node = st.pop();
            ls.add(node.val);
            
            if(node.right!=null){
                st.push(node.right);
            }
            
            if(node.left!= null){
                st.push(node.left);
            }
            
        }
        
        return ls;
    }
}