class Solution {
    public int findTargetSumWays(int[] nums, int target) {
     
    int n = nums.length;
    int totSum = 0;
    for(int x:nums){
        totSum +=x; 
    }
    
    if(totSum-target < 0) return 0;
    if((totSum-target)%2 == 1) return 0;    
        
    int s2 = (totSum-target)/2;
        
        
    int[][] dp = new int[n][s2+1];
    
    for(int[] rows: dp){
        Arrays.fill(rows,-1);
    }    
        return memoization(n-1,s2,nums,dp);
        
    }
    
    public int memoization(int indx,int target,int[] nums,int[][] dp){
            
        if(indx == 0){
            
            if(target == 0 && nums[0] == 0){
                return 2;
            }
            if(target == 0 || nums[0] == target){
                return 1;
            }
            return 0;
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target];
        }
        
        int notTake = memoization(indx-1,target,nums,dp);
        int take = 0;
        
        if(nums[indx]<= target){
            take = memoization(indx-1,target-nums[indx],nums,dp); 
        }
        return dp[indx][target] = take+notTake;
    }
    
}
















