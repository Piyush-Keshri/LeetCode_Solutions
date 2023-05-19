class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        solve(1,k,n,ls,res);
        
        return res;
    }
    
    public void solve(int indx,int k,int n,List<Integer>ls,List<List<Integer>>res){
        
        if(ls.size() > k){
            return;
        }
        
        else if(ls.size()==k && n==0){
            
            res.add(new ArrayList<>(ls));
        }
        else{
        for(int i=indx;i<=9;i++){
            
            ls.add(i);
            solve(i+1,k,n-i,ls,res);
            ls.remove(ls.size()-1);
        }
        
    }
}
}