class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return memoization(n-1,amount,coins,dp);
    }
    
    public int memoization(int indx,int target,int[] coins,int[][] dp){
        
        if(indx == 0){
            
            if(target%coins[indx] == 0){
               return 1;
            }
            return 0;
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target];
        }
        
        int notTake = memoization(indx-1,target,coins,dp);
        
        int take = 0;
        
        if(coins[indx]<=target){
            take = memoization(indx,target-coins[indx],coins,dp);
        }
        
        return dp[indx][target] = take+notTake;
    }
    
}











