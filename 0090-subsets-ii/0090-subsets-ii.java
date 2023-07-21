class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,ls,res);
        
        return new ArrayList<>(res);
        
    }
    
    public void solve(int indx,int[] nums,List<Integer>ls,Set<List<Integer>> res){
        
        if(indx == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        ls.add(nums[indx]);
        solve(indx+1,nums,ls,res);
        ls.remove(ls.size()-1);
        solve(indx+1,nums,ls,res);
    }
    
}