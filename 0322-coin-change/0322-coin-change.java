class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        int ans =  memoization(n-1,amount,dp,coins);
          if(ans >= (int)Math.pow(10,9)) return -1;
    return ans;
        
    }
    
    public int memoization(int indx,int amount,int[][] dp,int[] coins){
        
        if(indx == 0){
            
            if(amount%coins[0] == 0){
                return amount/coins[0];
            }
            return (int)1e9;
        }
        
        if(dp[indx][amount] != -1){
            return dp[indx][amount];
        }
        
        int notTake = memoization(indx-1,amount,dp,coins);
        
        int take = Integer.MAX_VALUE;
        
        if(coins[indx] <= amount){
            take = 1+ memoization(indx,amount-coins[indx],dp,coins);
        }
        return dp[indx][amount] = Math.min(take,notTake);
    }
    
}