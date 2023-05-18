class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        solve(0,candidates,target,ls,res);
        
        return res;
    }
    
    
    public void solve(int indx,int[] candidates,int target,List<Integer>ls,List<List<Integer>>res){
        
        if(indx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        
        if(target >= candidates[indx]){
            
            ls.add(candidates[indx]);
            solve(indx,candidates,target-candidates[indx],ls,res);
            ls.remove(ls.size()-1);
        }
        solve(indx+1,candidates,target,ls,res);
    }
    
}