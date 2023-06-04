class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }
        
        for(int indx1 = 1;indx1<=n;indx1++){
            
            for(int indx2 = 1;indx2<=m;indx2++){
                
                if(word1.charAt(indx1-1) == word2.charAt(indx2-1)){
                    dp[indx1][indx2] = 1+dp[indx1-1][indx2-1];
                }
                else{
                    dp[indx1][indx2] =Math.max(dp[indx1][indx2-1],dp[indx1-1][indx2]);
                }
                
            }
            
        }
        int len = dp[n][m];
        
        return (n-len)+(m-len);
        
    }
}