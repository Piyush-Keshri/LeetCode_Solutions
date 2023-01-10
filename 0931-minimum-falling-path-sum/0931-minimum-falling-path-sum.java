class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        
        for(int[] row: dp){
            Arrays.fill(row,(int)1e4);
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int col = 0; col<n;col++){
            int ans = memoization(n-1,col,n,matrix,dp);
            mini = Math.min(mini,ans);
        }
        return mini;
    }
    
    public int memoization(int row,int col,int n,int[][] matrix,int[][] dp){
        
        if(col<0 || col>=n){
            return (int)1e4;
        }
        
        if(row == 0){
            return matrix[0][col];
        }
        
        if(dp[row][col] != (int)1e4){
            return dp[row][col];
        }
        
        int up = matrix[row][col] + memoization(row-1,col,n,matrix,dp);
        int ld = matrix[row][col] + memoization(row-1,col-1,n,matrix,dp);
        int ud = matrix[row][col] + memoization(row-1,col+1,n,matrix,dp);
        
        return dp[row][col] = Math.min(up,Math.min(ld,ud));
    }
    
}

















