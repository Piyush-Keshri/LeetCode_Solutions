//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
      int[][] dp = new int[a][b];
      for(int[] row : dp){
          Arrays.fill(row,-1);
      }
      
     return memoization(0,0,a-1,b-1,dp);
    }
    
    public static int memoization(int i,int j,int row,int col,int[][]dp){
        
        if(i==row && j==col){
            return 1;
        }
        
        if(i>row || j>col){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int down = memoization(i+1,j,row,col,dp);
        int right = memoization(i,j+1,row,col,dp);
            
        return dp[i][j] = down + right;    
    }
}