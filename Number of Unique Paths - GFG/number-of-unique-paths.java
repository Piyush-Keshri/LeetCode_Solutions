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


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
       int[][] dp = new int[a+1][b+1];
       
       for(int[] row:dp){
           Arrays.fill(row,-1);
       }
       
       return memo(a-1,b-1,dp);
       
    }
    
    public static int memo(int row,int col,int[][] dp){
        
        if(row == 0 && col == 0){
            return  1;
        }
        
        if(row<0 || col<0){
            return  0;
        }
        
        if(dp[row][col]!= -1){
            return dp[row][col];
        }
        
        int up = memo(row-1,col,dp);
        int left = memo(row,col-1,dp);
        
        return dp[row][col] = up+left;
        
    }
    
}