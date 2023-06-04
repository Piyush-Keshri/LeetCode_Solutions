class Solution {
    public int longestPalindromeSubseq(String s) {
       
        int n = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(n-1,n-1,s,s1,dp);
        
    }
    
    public int solve(int indx1,int indx2,String s1,String s2,int[][] dp){
        
        if(indx1 < 0 || indx2 < 0){
            return 0;
        }
        
        if(dp[indx1][indx2] != -1){
            return dp[indx1][indx2];
        }
        
        if(s1.charAt(indx1) == s2.charAt(indx2)){
            
          return  dp[indx1][indx2] = 1+solve(indx1-1,indx2-1,s1,s2,dp);
            
        }
        
        return dp[indx1][indx2] = Math.max(solve(indx1,indx2-1,s1,s2,dp),solve(indx1-1,indx2,s1,s2,dp));
        
    }
    
}