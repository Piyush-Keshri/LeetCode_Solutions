class Solution {
    public int minPathSum(int[][] grid) {
     
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return memoization(m-1,n-1,grid,dp);
        
    }
    
    public int memoization(int row,int col,int[][] grid,int[][] dp){
        
        if(row == 0 && col == 0){
            return grid[0][0];
        }
        if(row<0 || col<0){
             return (int)Math.pow(10,9);
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int top = grid[row][col] + memoization(row-1,col,grid,dp);
        int left = grid[row][col] + memoization(row,col-1,grid,dp);
        
        return dp[row][col] = Math.min(top,left);
    }
    
}