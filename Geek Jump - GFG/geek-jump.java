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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        
        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        return helper(N-1,arr,dp);
    }
    
    public int helper(int indx,int[] arr,int[] dp){
        
        if(indx ==0){
            return 0;
        }
        
        if(dp[indx] != -1){
            return dp[indx];
        }
        
        
        int jumpOne = helper(indx-1,arr,dp) + Math.abs(arr[indx-1]-arr[indx]);
        
        int jumpTwo = Integer.MAX_VALUE;
        
        if(indx>1){
            
            jumpTwo = helper(indx-2,arr,dp) + Math.abs(arr[indx-2]-arr[indx]);
            
        }
        
        return dp[indx] = Math.min(jumpOne,jumpTwo);
    }
    
}