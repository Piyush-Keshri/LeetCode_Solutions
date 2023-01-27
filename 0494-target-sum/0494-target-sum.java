class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        int totSum = 0;
        
        for(int x : nums){
            totSum += x;
        }
        
        if(totSum < target || (totSum-target)%2 != 0) return 0;
        
        int s = (totSum-target)/2;
        
        int[][] dp = new int[n][s+1];
        
        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(nums[0]!=0 && nums[0]<=s) dp[0][nums[0]] = 1;
        
        for(int indx = 1;indx<n;indx++){
            
            for(int tar = 0;tar<=s;tar++){
                
                int notTake = dp[indx-1][tar];
                int take = 0;
                
                if(nums[indx]<=tar){
                    take = dp[indx-1][tar-nums[indx]];
                }
                
                dp[indx][tar]  = take+notTake;
            }
            
        }
        return dp[n-1][s];
    }
}