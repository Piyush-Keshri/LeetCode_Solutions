class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
    
        List<Double> res = new ArrayList<Double>();
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            double sum = 0;
            for(int i =0;i<n;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                 if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(sum/n);
        }
        return res;
    }
}