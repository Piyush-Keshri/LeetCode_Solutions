class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        int ans = solve(n-1,coins,amount,dp);
        
        if(ans >= (int)Math.pow(10,9)) return -1;
             return ans;
        
    }
    
    public int solve(int indx,int[] coins,int amount,int[][] dp){
        
        if(indx == 0){
            if(amount%coins[0] == 0)
                return amount/coins[0];
            else
                return (int)Math.pow(10,9);
        }
        
        if(dp[indx][amount]!=-1){
            return dp[indx][amount];
        }
        
        int notTake = 0 + solve(indx-1,coins,amount,dp);
        int take = (int)Math.pow(10,9);
        
        if(amount>= coins[indx]){
            take = 1+solve(indx,coins,amount-coins[indx],dp);
        }
        
        return dp[indx][amount] = Math.min(take,notTake);
    }
    
}