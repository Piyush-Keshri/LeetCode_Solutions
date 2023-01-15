//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends

class Solution{
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
    
        int[][] dp = new int[N][sum+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return memoization(N-1,sum,arr,dp);
    }
    
    static Boolean memoization(int indx,int target,int[] arr,int[][] dp){
        
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