//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        
        int start = 0;
        int end = arr.length-1;
        
        int minVal = Integer.MAX_VALUE;
        
        while(start<=end){
            
            if(arr[start]<=arr[end]){
                minVal = Math.min(arr[start],minVal);
                break;
            }
            
            int mid = start+(end-start)/2;
            
            if(arr[start] <= arr[mid]){
                minVal = Math.min(minVal,arr[start]);
                start = mid+1;
            }
            
            if(arr[mid]<=arr[end]){
                minVal = Math.min(minVal,arr[mid]);
                end = mid-1;
            }
            
        }
        return minVal;
    }
}
