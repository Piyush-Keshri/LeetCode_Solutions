class Solution {
    int mod = (int) 1e9+7;
    public int countPaths(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m  = grid[0].length;
        
        Integer[][] dp = new Integer[n][m];
        // Traversing each and every cell to get the path count
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res = res+ solve(i,j,grid,dp);
                res = res%mod;
            }
        }
         // adding the single cell paths
        return (res+ n*m) %mod;
    }
    
    
    public int solve(int i, int j, int[][] grid, Integer[][] dp)
    {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        
		// base condition
        if(i<0 || j<0 || i>=n || j>=m)
        {
            return 0;
        }
        
		// Moving Up
        if(i > 0 && grid[i][j] < grid[i-1][j])
        {
            count  = count + solve(i-1, j, grid, dp) +1;
        }
        
		// Moving left
        if(j > 0 && grid[i][j] < grid[i][j-1])
        {
            count  = count + solve(i, j-1, grid, dp) +1;
        }
        // Moving Down
        if(i < n-1 && grid[i][j] < grid[i+1][j])
        {
            count  = count + solve(i+1, j, grid, dp) +1;
        }
        // Moving Right
        if(j < m-1 && grid[i][j] < grid[i][j+1])
        {
            count  = count + solve(i, j+1, grid, dp) +1;
        }
        
        count = count%mod;
        dp[i][j] = count;
        return count;
    }
}