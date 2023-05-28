class Solution {
    long ans =  Integer.MIN_VALUE;
    public long maxStrength(int[] nums) {
    
       solve(0,nums,1,0);
        return ans;
    }
    public void solve(int indx,int[] nums,long prod,int size){
        
        
        if(indx == nums.length){
            if(size!=0) ans = Math.max(ans,prod);
            return;
        }
        
        solve(indx+1,nums,prod*nums[indx],size+1);
        solve(indx+1,nums,prod,size);
    }
    
}