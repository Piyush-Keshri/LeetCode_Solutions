class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp =new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            
            ans = Math.min(ans,solve(n-1,i,matrix,dp));
            
        }
        return ans;
    }
    
    
    public int solve(int row,int col,int[][] mat,int[][] dp){
        if(row<0 || col<0 || col>mat.length-1){
            return  (int)Math.pow(10,9);
        }
        
        if(row == 0){
            return mat[row][col];
        }
        
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int up = mat[row][col] + solve(row-1,col,mat,dp);
        int upleft = mat[row][col] + solve(row-1,col-1,mat,dp);
        int upright = mat[row][col] + solve(row-1,col+1,mat,dp);
        
        return dp[row][col] = Math.min(up,Math.min(upleft,upright));
        
    }
    
}