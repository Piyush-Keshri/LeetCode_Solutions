/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
       
        int height = 0;
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return height;
        }
        q.add(root);
        
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size -- > 0){
                
                Node curr = q.poll();
                
                for(Node node:curr.children){
                    
                    if(node != null){
                        q.add(node);
                    }
                    
                }
            }
            height++;
            
        }
        return height;
    }
}