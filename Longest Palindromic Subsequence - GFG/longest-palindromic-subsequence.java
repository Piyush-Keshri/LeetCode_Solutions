//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
       int n = S.length();
       StringBuilder sb = new StringBuilder(S);
       String S1 = sb.reverse().toString();
       
       int[][] dp = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            
            dp[i][0] = 0;
            
        }
        
        for(int i=0;i<=n;i++){
            
            dp[0][i] = 0;
            
        }
        
        for(int indx1 = 1;indx1<=n;indx1++){
            
            for(int indx2 = 1;indx2<=n;indx2++){
                
                
                if(S.charAt(indx1-1) == S1.charAt(indx2-1)){
                    dp[indx1][indx2] = 1+dp[indx1-1][indx2-1];
                }
                else{
                    dp[indx1][indx2] = Math.max(dp[indx1][indx2-1],dp[indx1-1][indx2]);
                }
                
            }
            
        }
        return dp[n][n];
        
    }
    
}














