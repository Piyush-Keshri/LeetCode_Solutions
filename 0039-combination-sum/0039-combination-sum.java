class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        solve(0,candidates,target,ls,res);
        
        return res;
    }
    
    public void solve(int indx, int[] nums,int target,List<Integer> ls, List<List<Integer>> res){
        
        if(indx == nums.length){
            
            if(target == 0){
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        
        if(target >= nums[indx]){
            ls.add(nums[indx]);
            solve(indx,nums,target-nums[indx],ls,res);
            ls.remove(ls.size()-1);
        }
        
        solve(indx+1,nums,target,ls,res);
    }
    
}