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
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K){
        
        int dp[] = new int[N];
        Arrays.fill(dp,-1);
        
    return memoization(N-1,arr,dp,K);

    }
    
    public int memoization(int indx,int[] arr,int[] dp,int K){
        
        if(indx == 0){
            return 0;
        }
        
        if(dp[indx] != -1){
            return dp[indx];
        }
        
        int minJump = Integer.MAX_VALUE;
        
        for(int i = 1;i<=K;i++){
            
            if(indx - i >=0){
                
                int jump = memoization(indx-i,arr,dp,K) + Math.abs(arr[indx] - arr[indx-i]);
                minJump = Math.min(jump,minJump);
            }
        }
       return dp[indx] = minJump;
    }
    
}
