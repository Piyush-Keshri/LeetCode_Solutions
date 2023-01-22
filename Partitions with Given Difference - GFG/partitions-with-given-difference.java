//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution{
    int mod = (int)1e9+7;
    
    public int countPartitions(int n, int d, int arr[]){
        
        int sum = 0;
        for(int x:arr){
            sum+=x;
        }
        
        if(sum<d) return 0;
        if((sum-d) % 2 == 1) return 0;
        
        int target = (sum-d)/2;   
         
        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return memoization(n-1,target,arr,dp);
    }
    
    public int memoization(int indx,int target,int[] arr,int[][] dp){
        
        if(indx == 0){
            
            if(target == 0 && arr[0] == 0){
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
        
        dp[indx][target] = (take + notTake)%mod;
        return dp[indx][target];
    }
    
}












