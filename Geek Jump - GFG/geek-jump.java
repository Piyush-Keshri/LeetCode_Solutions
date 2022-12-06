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
        
        int dp[] = new int[N];
        Arrays.fill(dp,-1);
        int jumpTwo = Integer.MAX_VALUE;
        dp[0] = 0;
        
        for(int i =1;i<N;i++){
            
            int jumpOne = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            
            if(i>1){
                jumpTwo = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            
            dp[i] = Math.min(jumpOne,jumpTwo);
            
        }
        
        return dp[N-1];
    }
}