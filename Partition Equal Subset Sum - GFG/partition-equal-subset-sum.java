//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        
        for(int x:arr){
            sum+=x;
        }
        
        if(sum%2 !=0){
            return 0;
        }
        
        int[][] dp = new int[N][sum/2 + 1];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        
        boolean ans = memoization(N-1,sum/2,arr,dp);
        
        if(ans){
            return 1;
        }
        return 0;
        
    }
    
    public static boolean memoization(int indx,int target,int[] arr,int[][] dp){
        
       if(target == 0){
            return true;
        }
        
        if(indx == 0){
            return target == arr[0];
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target] == 0?false:true;
        }
        
        boolean notTaken = memoization(indx-1,target,arr,dp);
        boolean taken = false;
        
        if(arr[indx] <= target){
            taken = memoization(indx-1,target-arr[indx],arr,dp);
        }
        dp[indx][target] = notTaken || taken ? 1:0;
            return notTaken || taken;
        
        
    }
}











