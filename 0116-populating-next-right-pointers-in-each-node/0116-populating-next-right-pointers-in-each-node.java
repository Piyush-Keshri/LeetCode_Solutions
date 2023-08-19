/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        root.next = null;
    Queue<Node> q = new LinkedList<>();
     
        q.add(root);
        // List<List<Node>> res = new ArrayList<>();
        while(!q.isEmpty()){
            
            int level = q.size();
            List<Node> ls= new ArrayList<>();
            
            for(int i=0;i<level;i++){
                
            Node curr = q.poll();
            ls.add(curr);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
                  
        }
            
            for(int i=1;i<ls.size();i++){
                
                Node prev = ls.get(i-1);
                Node curr = ls.get(i);
                prev.next = curr;
                
                if(i == ls.size()-1){
                    curr.next = null;
                }
                
            }   
    }
        
    return root;        
}

}























