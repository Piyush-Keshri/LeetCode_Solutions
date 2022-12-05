class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
       int indx = 0;
        
     helper(indx,nums,res,sub);
        return res;
    }
    
    public void helper(int indx,int[] nums,List<List<Integer>>res,List<Integer>sub){
        
        if(indx == nums.length){
            res.add(new ArrayList<Integer>(sub));
            return;
        }
        
        sub.add(nums[indx]);
        helper(indx+1,nums,res,sub);
        
        sub.remove(sub.size()-1);
        helper(indx+1,nums,res,sub);
        
    }
    
}