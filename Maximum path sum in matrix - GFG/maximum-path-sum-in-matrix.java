//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
      int[][] dp = new int[N][N];
      
      for(int[] row : dp){
        Arrays.fill(row,-1);
      }
       int ans = Integer.MIN_VALUE;
       
       for(int i = 0 ;i<N;i++){
          int temp = memoization(N-1,i,N,dp,Matrix);
          ans = Math.max(ans,temp); 
       }
       return ans;
    }
    
    
    static int memoization(int row,int col,int N,int[][] dp,int[][] Matrix){
        
        if(col<0 || col>=N){
            return -1;
        }
        
        if(row == 0){
            return Matrix[0][col];
        }
        
        if(dp[row][col]!= -1){
            return dp[row][col];
        }
        
        int up = Matrix[row][col] + memoization(row-1,col,N,dp,Matrix);
        int ld = Matrix[row][col] + memoization(row-1,col-1,N,dp,Matrix);
        int rd = Matrix[row][col] + memoization(row-1,col+1,N,dp,Matrix);
        
        dp[row][col] = Math.max(up,Math.max(ld,rd));
        
        return dp[row][col];
        
    }
    
}