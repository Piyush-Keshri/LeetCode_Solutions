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
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int i = arr.length-2;
        
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        
        if(i>=0){
            
            int j = arr.length-1;
            
            while(arr[j]<=arr[i]){
                j--;
            }
            
            swap(arr,i,j);
        }
        
        reverse(arr,i+1,arr.length-1);
        
        for(int k = 0;k<arr.length;k++){
            
            ans.add(arr[k]);
            
        }
        return ans;
    }
    
    
    public static void swap(int[]A,int i,int j){
        
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        
    }
    
    public static void reverse(int[]A,int i,int j){
        
        while(i<j){
            swap(A,i++,j--);
        }
    }
}


















