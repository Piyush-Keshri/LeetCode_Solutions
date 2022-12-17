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
    return tabulation(a,b,dp);
    }
    
    public static int tabulation(int row,int col,int[][] dp){
        
        for(int i=0;i<row;i++){
            
            dp[i][0] = 1;
        }
        
        for(int j =0;j<col;j++){
            
            dp[0][j] = 1;
        }
        
        for(int i=1 ;i<row;i++){
            
            for(int j=1;j<col;j++){
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                
            }
            
        }
       return dp[row-1][col-1]; 
    }
    
}