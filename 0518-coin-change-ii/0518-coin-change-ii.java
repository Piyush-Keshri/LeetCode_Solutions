class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int[] row:dp)
        {Arrays.fill(row,-1);}
    
        return solve(n-1,amount,coins,dp);
        
    }
    
    public int solve(int indx,int amount,int[] coins,int[][] dp){
        
        if(indx == 0){
            if(amount%coins[0] == 0) return 1;
           
            return 0;
        }
        
        if(dp[indx][amount] != -1){
            return dp[indx][amount];
        }
        
        int nt = solve(indx-1,amount,coins,dp);
        int tk = 0;
        
        if(amount >= coins[indx]){
            tk = solve(indx,amount-coins[indx],coins,dp);
        }
        
        return dp[indx][amount] = tk + nt;
        
    }
}