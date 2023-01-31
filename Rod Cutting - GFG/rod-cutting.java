//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n][n+1];
        
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        
        return memoization(n-1,n,price,dp);
    }
    
    public int memoization(int indx,int target,int[] price,int[][] dp){
        
        if(indx == 0){
            return target*price[0];
        }
        
        if(dp[indx][target]!=-1){
            return dp[indx][target];
        }
        
        int notTake = memoization(indx-1,target,price,dp);
        
        int take = Integer.MIN_VALUE;
        int rods = indx+1;
        if(rods<=target){
            take = price[indx]+memoization(indx,target-rods,price,dp);
        }
        return dp[indx][target] = Math.max(take,notTake);
    }
    
}