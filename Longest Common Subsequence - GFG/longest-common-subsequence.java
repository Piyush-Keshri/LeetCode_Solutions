//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        
        int[][] dp = new int[x+1][y+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(x-1,y-1,s1,s2,dp);
        
    }
    
    static int solve(int indx1,int indx2,String s1,String s2,int[][] dp){
        
        if(indx1<0 || indx2<0){
            return 0;
        }
        
        if(dp[indx1][indx2] != -1){
            
            return dp[indx1][indx2];
        }
        
        if(s1.charAt(indx1) == s2.charAt(indx2)){
            return dp[indx1][indx2] = 1+solve(indx1-1,indx2-1,s1,s2,dp);
        }
        
        dp[indx1][indx2] = Math.max(solve(indx1-1,indx2,s1,s2,dp),solve(indx1,indx2-1,s1,s2,dp));
        return dp[indx1][indx2];
    }
    
    
}