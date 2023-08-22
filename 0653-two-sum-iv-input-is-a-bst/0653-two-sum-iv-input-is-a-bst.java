
class Solution {
    public boolean findTarget(TreeNode root, int k) {
    
    ArrayList<Integer> nums = new ArrayList<Integer>();
     
        inorder(root,nums);
        
        int lo = 0;
        int hi = nums.size()-1;
        
        while(lo<hi){
            
            int sum = nums.get(lo) + nums.get(hi);
            
            if(sum == k) return true;
            
            if(sum<k) lo++;
            else hi--;
                
        }
       return false; 
    }  
    
    public void inorder(TreeNode root,ArrayList<Integer> nums){
        
        if(root == null){
            return ;
        }
        
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
    
}