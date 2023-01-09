class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int[][] dp = new int[n][n]; 
        
        for(int[] row: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        return memoization(triangle,0,0,dp);
    }
    
    public int memoization(List<List<Integer>> triangle,int row,int col,int[][] dp){
       
//         Base Case
        if(row == triangle.size()){
            return 0;
        }
        
        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        
//         We can traverse either down or diagonal
        
int traverse = Math.min(memoization(triangle,row+1,col,dp),memoization(triangle,row+1,col+1,dp));

        dp[row][col] = triangle.get(row).get(col) + traverse;
        
        return dp[row][col];        
    }
    
}