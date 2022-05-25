class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        if(root == null){
            return res;
        }
        queue.offer(root);
        boolean flag = true;
        
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            for(int i = 0;i<levelNum;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                if(flag == true)  {                                                        sublist.add(queue.poll().val);
            }
                else{
                    sublist.add(0,queue.poll().val);
                }
                
            }
            flag = !flag;
                res.add(sublist);
        }
        return res;
    }
}