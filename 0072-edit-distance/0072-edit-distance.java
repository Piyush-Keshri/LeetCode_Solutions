class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(n-1,m-1,word1,word2,dp);
        
    }
    
    public int solve(int indx1,int indx2,String s1,String s2,int[][] dp){
        
        if(indx1<0){
            return indx2+1;
        }
        if(indx2<0){
            return indx1+1;
        }
        
        if(dp[indx1][indx2] != -1){
            return dp[indx1][indx2];
        }
        
        if(s1.charAt(indx1) == s2.charAt(indx2)){
           return dp[indx1][indx2] = solve(indx1-1,indx2-1,s1,s2,dp);
        }
        
        int insert = 1+solve(indx1,indx2-1,s1,s2,dp);
        int delete = 1+solve(indx1-1,indx2,s1,s2,dp);
        int replace = 1+solve(indx1-1,indx2-1,s1,s2,dp);
        
       return dp[indx1][indx2] = Math.min(insert,Math.min(delete,replace));
        
        
    }
    
}