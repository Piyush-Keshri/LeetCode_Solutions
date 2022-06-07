class Solution {
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<Integer>();
       Stack<TreeNode> st = new Stack<TreeNode>();
      if(root == null){
          return result;
      } 
      st.push(root); 
        while(!st.isEmpty()){
            root = st.pop();
            result.add(root.val);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
       return result;
   }
    
}