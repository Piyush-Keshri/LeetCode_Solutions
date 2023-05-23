class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
 Set<List<Integer>> res = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        
        solve(nums,vis,ls,res);
        
        return new ArrayList<>(res);
    }
    
    public void solve(int[] nums,boolean[]vis,List<Integer> ls,Set<List<Integer>>res){
        
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(vis[i] == false){
                vis[i] = true;
                ls.add(nums[i]);
                solve(nums,vis,ls,res);
                ls.remove(ls.size()-1);
                vis[i] = false;
            }
            
        }
        
    } 
    
}