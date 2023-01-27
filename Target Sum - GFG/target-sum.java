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
       int totSum=0;
       for(int x: A){
           totSum+=x; 
       }
       if(totSum < target) return 0;
       if((totSum-target)%2 == 1) return 0;
       
       int s2 = (totSum-target)/2;
      
       int[][] dp = new int[N][s2+1]; 
       
       for(int[] rows : dp){
           Arrays.fill(rows,-1);
       }
       
       return memoization(N-1,s2,A,dp);
    }
    
    public static int memoization(int indx,int target,int[] arr,int[][] dp){
        
        if(indx == 0){
            
            if(target == 0 && arr[0] ==0){
                return 2;
            }
            if(target == 0 || arr[0] == target){
                return 1;
            }
            return 0;
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target];
        }
    
        int notTake = memoization(indx-1,target,arr,dp);
        
        int take = 0;
        
        if(arr[indx] <= target){
            take = memoization(indx-1,target-arr[indx],arr,dp);
        }
        return dp[indx][target] = take+notTake;
    }
    
};
















