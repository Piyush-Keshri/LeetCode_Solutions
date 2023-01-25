class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1]; 
        
        for(int i =0;i<=amount;i++){
            
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
            else
                dp[0][i] = (int)1e9;
        }
        
        for(int i = 1;i<n;i++){
            
            for(int tar = 0 ;tar<=amount;tar++){
                
                int notTake = dp[i-1][tar];
                int take = (int)1e9;
                
                if(coins[i]<=tar){
                    take = 1+dp[i][tar-coins[i]];
                }
                dp[i][tar] = Math.min(notTake,take);
            }
            
        }
        
        if(dp[n-1][amount] >= (int)1e9){
            return -1;
        }
        return dp[n-1][amount];
    }
}