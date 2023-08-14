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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null){
            return ls;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            
            int levelNum = q.size();
            List<Integer> ls1 = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                
                TreeNode curr = q.poll();
                ls1.add(curr.val);
            
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            
            }
            ls.add(Collections.max(ls1));
        }
        return ls;
        
    }
}