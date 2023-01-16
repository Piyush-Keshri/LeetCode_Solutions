class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int x: nums){
            sum+=x;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        
        int[][] dp = new int[n][sum/2 + 1]; 
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return  memoization(n-1,sum/2,nums,dp);
    }
    
    public boolean memoization(int indx,int target,int[] arr,int[][] dp){
        
         if(target == 0){
            return true;
        }
        
        if(indx == 0){
            return target == arr[0];
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target] == 0?false:true;
        }
        
        boolean notTaken = memoization(indx-1,target,arr,dp);
        boolean taken = false;
        
        if(arr[indx] <= target){
            taken = memoization(indx-1,target-arr[indx],arr,dp);
        }
        
        dp[indx][target] = notTaken || taken ? 1:0;
            return notTaken || taken;
        
    }
    
}













