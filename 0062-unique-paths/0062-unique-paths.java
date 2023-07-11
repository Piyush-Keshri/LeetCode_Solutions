class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] rows:dp){
            
            Arrays.fill(rows,-1);
        }
        return solve(0,0,m,n,dp);
        
        
    }
    
    public int solve(int row,int col,int m,int n,int[][] dp){
        
        if(row>m-1 || col>n-1){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        if(row == m-1 && col == n-1){
            return 1;
        }
        
        
        int up = solve(row+1,col,m,n,dp);
        
        int left = solve(row,col+1,m,n,dp);
        
        return dp[row][col] = up+left;
        
    }
    
}