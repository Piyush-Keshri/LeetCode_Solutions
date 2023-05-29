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


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        boolean[][] dp = new boolean[N+1][sum+1];
        
        for(int indx=0;indx<N;indx++){
            dp[indx][0] = true;
        }
        
        if(arr[0]<=sum){
            dp[0][arr[0]] = true;
        }
        
        for(int indx=1;indx<N;indx++){
            
            for(int target=1;target<=sum;target++){
             
             boolean nt = dp[indx-1][target];
             boolean t = false;
             
             if(target>=arr[indx]){
                 t = dp[indx-1][target-arr[indx]];
             }
               dp[indx][target] = nt||t;  
            }
        }
        return dp[N-1][sum];
    }
}