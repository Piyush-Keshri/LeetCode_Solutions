class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
       return tabulation(m,n,dp);
        
    }
    
    public int tabulation(int row,int col,int[][]dp){
        
        for(int i = 0; i<row;i++){
            dp[i][0] = 1;
        }
        
        for(int j= 0;j<col;j++){
            dp[0][j]=1;
        }
        
        for(int i = 1;i<row;i++){
            
            for(int j = 1;j<col;j++){
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                
            }
            
        }
        return dp[row-1][col-1];
    }
}