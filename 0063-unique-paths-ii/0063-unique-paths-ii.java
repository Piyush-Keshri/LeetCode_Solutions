class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int n = obstacleGrid.length;
       int m = obstacleGrid[0].length; 
       
        if(obstacleGrid[n-1][m-1] == 1 ||obstacleGrid[0][0] == 1  ){
            return 0;
        }
        
       int[][] dp = new int[n+1][m+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
      return memo(n-1,m-1,obstacleGrid,dp);  
    }
    
    public int memo(int row,int col,int[][] grid,int[][] dp){
        
        if(row == 0 && col == 0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int up=0;int left = 0;
        
        if(grid[row][col] != 1){
            
            up = memo(row-1,col,grid,dp);
            left = memo(row,col-1,grid,dp);
            
        }
        return dp[row][col] = up+left;
    }
    
}