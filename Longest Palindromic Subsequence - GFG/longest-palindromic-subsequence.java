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
        
        for(int[] arr : dp){
            
            Arrays.fill(arr,-1);
            
        }        
        
        return  solve(n-1,n-1,S,S1,dp);
        
    }
    
    
    public int solve(int indx1,int indx2,String s1,String s2,int[][] dp){
        
        if(indx1<0 || indx2<0){
            return 0;
        }
        
        
        if(dp[indx1][indx2] != -1){
            return dp[indx1][indx2];
            
        }
        
        
        if(s1.charAt(indx1) == s2.charAt(indx2)){
            
            return dp[indx1][indx2] = 1 + solve(indx1-1,indx2-1,s1,s2,dp);
            
        }
            
        return dp[indx1][indx2] = Math.max(solve(indx1-1,indx2,s1,s2,dp),solve(indx1,indx2-1,s1,s2,dp));
        
        
    }
    
}














