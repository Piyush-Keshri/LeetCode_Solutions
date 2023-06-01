class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        
        for(int amnt = 0;amnt<=amount;amnt++){
            if(amnt % coins[0] == 0) dp[0][amnt] = 1;
        }
        
        
        for(int indx = 1;indx<n;indx++){
            
            for(int amnt =0;amnt<=amount;amnt++){
                
                int nt = dp[indx-1][amnt];
                int tk = 0;
                
                if(amnt>=coins[indx]){
                    tk = dp[indx][amnt-coins[indx]];
                }
                dp[indx][amnt] = tk+nt;
            }            
        }
            
        return dp[n-1][amount];
    }
}