class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        
       return solve(n-1,m-1,s,t,dp);
        
    }
    
    public int solve(int indx1,int indx2,String s1,String s2,int[][] dp){
        if(indx2 < 0){
            return 1;
        }
        
        if(indx1 < 0){
            return 0; 
        }
        
        
        if(dp[indx1][indx2] != -1){
            return dp[indx1][indx2];
        }
        
        if(s1.charAt(indx1) == s2.charAt(indx2)){
           return  dp[indx1][indx2] =( solve(indx1-1,indx2-1,s1,s2,dp) + solve(indx1-1,indx2,s1,s2,dp));
        }    
        else
       return dp[indx1][indx2] = solve(indx1-1,indx2,s1,s2,dp);
        
    }

}










