class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row:dp){
           Arrays.fill(row,-1); 
        }
        return memo(m-1,n-1,dp);
    }
    
    public int memo(int row,int col,int[][] dp){
        
        if(row == 0 || col == 0){
            return dp[row][col] = 1;
        }
        
        if(row<0 || col<0){
            return dp[row][col] = 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int up = memo(row-1,col,dp);
        int left = memo(row,col-1,dp);
        
        return dp[row][col] = up+left;
    }
    
}