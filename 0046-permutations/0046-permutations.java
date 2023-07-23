class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        boolean[] vis = new boolean[nums.length+1];
        
        solve(0,nums,vis,ls,res);
        
        return res;
    }
    
    public void solve(int indx,int[] nums,boolean[] vis,List<Integer> ls,List<List<Integer>> res){
        
        if(ls.size() == nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(vis[i] == false){
                vis[i] = true;
                ls.add(nums[i]);
                solve(i+1,nums,vis,ls,res);
                ls.remove(ls.size()-1);
                vis[i] = false;
            }
            
        }
    }
     
}