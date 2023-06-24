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
class Pair{
    TreeNode node;
    int level;
    
    public Pair(TreeNode node,int level){
        
        this.node = node;
        this.level = level;
        
    }
    
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair pair =q.poll();
           TreeNode curr = pair.node;
            int level = pair.level;
                
                map.put(level,curr.val);
                
                if(curr.left!=null){
                    q.add(new Pair(curr.left,level+1));
                }
                if(curr.right!= null){
                    q.add(new Pair(curr.right,level+1));
                }
            }
            
        
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
            res.add(entry.getValue());
            
        }
        return res;
    }
}