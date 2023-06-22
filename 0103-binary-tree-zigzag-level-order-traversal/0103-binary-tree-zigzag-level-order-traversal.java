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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        boolean rev = false;
        
        while(!q.isEmpty()){
            
            int levelNum = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right !=null){
                    q.add(curr.right);
                }
                
                ls.add(curr.val);
            }
            if(rev){
                Collections.reverse(ls);
            }
            res.add(new ArrayList<>(ls));
            rev = !rev;
        }
        return res;
    }
}