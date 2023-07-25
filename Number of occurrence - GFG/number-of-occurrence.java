//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int last = findLast(arr,n,x);
        int first = findFirst(arr,n,x);
        
        return last-first+1;    
        
    }
    
    
    int findFirst(int[] arr,int n,int target){
        
        int lo = 0;
        int hi = arr.length-1;
        int ans = 0;
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid] == target){
                
                ans = mid;
                hi = mid-1;
                
            }
            
            else if(arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
            
        }
        return ans;
    }
    
    
    int findLast(int[] arr,int n,int target){
        
        int lo = 0;
        int hi = arr.length-1;
        int ans = -1;
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid] == target){
                
                ans = mid;
                lo = mid+1;
                
            }
            
            else if(arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
            
        }
        return ans;
    }
    
    
    
    
}