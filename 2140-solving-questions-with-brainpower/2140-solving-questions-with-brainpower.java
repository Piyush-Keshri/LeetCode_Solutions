class Solution {
    public long mostPoints(int[][] questions) {
        int n =questions.length;
        long[] dp = new long[n];
        
        Arrays.fill(dp,-1);
        
        return memoization(0,questions,dp);
    }
    
    public long memoization(int i,int[][] questions,long[] dp){
        
        if(i>=questions.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int points = questions[i][0];
        int skip = questions[i][1];
        
        dp[i] = (long)Math.max(points+memoization(i+skip+1,questions,dp),memoization(i+1,questions,dp));
        
        return dp[i];
    }
    
}