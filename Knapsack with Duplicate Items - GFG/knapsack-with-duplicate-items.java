//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W+1];
        
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = (int)(i/wt[0]) * val[0]; 
        }
        
        for(int indx = 1;indx<N;indx++){
            
            for(int tar = 0;tar<=W;tar++){
                
                int notTake = dp[indx-1][tar];
                int take = Integer.MIN_VALUE;
                
                if(wt[indx]<=tar)
                take = val[indx] +dp[indx][tar-wt[indx]];
            
                dp[indx][tar] = Math.max(take,notTake);
                
            }
            
        }
        return dp[N-1][W];
    }
}