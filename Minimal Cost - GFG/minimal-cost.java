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
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        
       return tabulation(N,arr,dp,K);
        
    }
    
    public int tabulation(int N,int[] arr,int[] dp,int K){
        
        dp[0] = 0;
        
        for(int i = 1;i<N;i++){
            
            int minJump = Integer.MAX_VALUE;
            
            for(int j = 1 ;j<=K;j++){
                
                if(i-j>=0){
                    
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minJump = Math.min(jump,minJump);
                }
            }
            
            dp[i] = minJump;
        }
        return dp[N-1];
    }
    
}
