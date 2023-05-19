class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ls,res);
        
        return res;
    }
    
    public void solve(int indx,int[] candidates,int target,List<Integer>ls,List<List<Integer>>res){
        
            if(target == 0){
                res.add(new ArrayList<>(ls));
                return;
            }
        
        
        for(int i=indx;i<candidates.length;i++){
            
            if(i>indx && candidates[i] == candidates[i-1]) continue;
            
            if(target<candidates[i]) break;
            
            ls.add(candidates[i]);
            solve(i+1,candidates,target-candidates[i],ls,res);
            ls.remove(ls.size()-1);
        }
        
    }
    
}