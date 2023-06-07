class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(0,-1,nums,dp);
        
    }
    
    
    public int solve(int indx,int prev,int[] nums,int[][] dp){
        
        if(indx == nums.length){
            return 0;
        }
        
        if(dp[indx][prev+1] != -1){
            return dp[indx][prev+1];
        }
        
        int nt = solve(indx+1,prev,nums,dp);
        
        int tk = 0;
        
        if(prev == -1 || nums[indx] > nums[prev]){
            tk = 1+solve(indx+1,indx,nums,dp);
        }
        
        return dp[indx][prev+1] = Math.max(tk,nt);
    }

}



