class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
       return memoization(0,0,m-1,n-1,dp);
        
    }
    
    public int memoization(int i,int j,int row,int col,int[][]dp){
        
        if(i == row && j == col){
            return 1;
        }
        if(i > row || j > col){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int down = memoization(i+1,j,row,col,dp);
        int right = memoization(i,j+1,row,col,dp);
        
        return dp[i][j] = down+right;
        
    }
}