//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        int[][] dp = new int[n+1][W+1];
        
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(n-1,W,wt,val,dp);
        
    } 
    
    static int solve(int indx,int W,int[] wt,int[] val,int[][] dp){
        
        if(indx == 0){
            
            if(W>=wt[0]) return val[0];
            return 0;
            
        }
        
        if(dp[indx][W] != -1){
            return dp[indx][W];
        }
        
        int notTake = 0 + solve(indx-1,W,wt,val,dp);
        int take = 0;
        
        if(W>=wt[indx]){
            
            take = val[indx] + solve(indx-1,W-wt[indx],wt,val,dp);
            
        }
        return dp[indx][W] = Math.max(take,notTake);
    }
    
}


