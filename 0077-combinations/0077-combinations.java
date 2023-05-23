class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        
        solve(0,n,k,nums,ls,res);
        return res;
    }
    
    public void solve(int indx,int n,int k,int[] nums,List<Integer> ls,List<List<Integer>>res){
        
        if(ls.size() == k){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i=indx;i<n;i++){
            
            ls.add(nums[i]);
            solve(i+1,n,k,nums,ls,res);
            ls.remove(ls.size()-1);
            
        }
        
    }
    
}