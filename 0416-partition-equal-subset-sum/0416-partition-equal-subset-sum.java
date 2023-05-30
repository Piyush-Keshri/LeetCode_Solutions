class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2 != 0) return false;
        
        int[][] dp = new int[nums.length][(sum/2)+1];
      
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        
       return solve(nums.length-1,sum/2,nums,dp);
        
    }
    
    public boolean solve(int indx,int target,int[] arr,int[][] dp){
        
        if(target == 0){
            return true;
        }
        if(indx == 0){
            return arr[0] == target;
        }
        if(dp[indx][target] != -1){
            return dp[indx][target] == 0?true:false;
        }
        
        boolean nt = solve(indx-1,target,arr,dp);
        
        boolean take =false;
        
        if(target>=arr[indx]){
            take = solve(indx-1,target-arr[indx],arr,dp);
        }
        
        dp[indx][target] = take||nt?0:1;
        
        return take||nt;
    }
    
}










