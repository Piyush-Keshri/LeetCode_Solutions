//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        
        int totSum = 0;
        for(int x: A){
            totSum+=x;
        }
        
        if(totSum<target || (totSum-target)%2 !=0) return 0;
        int s = (totSum-target)/2;
        
        int[][] dp = new int[N][s+1];
        
        if(A[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        if(A[0]!=0 && A[0]<=s) dp[0][A[0]] = 1;
        
        for(int i=1;i<N;i++){
            for(int tar = 0;tar<=s;tar++){
                
                int notTake = dp[i-1][tar];
                int take = 0;
                
                if(A[i] <=tar){
                    take = dp[i-1][tar-A[i]];
                    
                }
                dp[i][tar] = take+notTake;
            }
        }
        
        return dp[N-1][s];
    }
};