class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n= triangle.size();
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
      return solve(0,0,n,dp,triangle);
    }
    public int solve(int row,int col,int n,int[][] dp,List<List<Integer>> triangle){
        
        if(row == n-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col)+solve(row+1,col,n,dp,triangle);
        int diag = triangle.get(row).get(col)+ solve(row+1,col+1,n,dp,triangle);
        
        return dp[row][col] = Math.min(down,diag);
        
    }
    
}