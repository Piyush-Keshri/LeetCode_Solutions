//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countMinOperations(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int countMinOperations(int[] arr, int n) {
        
        int ans= 0;
        
        while(true){
            
            int zeros = 0;
            int i;
            
            for(i = 0;i<n;i++){
                
                if(arr[i]%2 == 1){
                    break;
                }
                else if(arr[i] == 0){
                    zeros++;
                }
            }
            
            if(zeros == n){
                return ans;
            }
            
            if(i == n){
                for(int j = 0;j<n;j++){
                    arr[j]/=2;
                }
                ans++;
            }
            
            for(int j = 0;j<n;j++){
                
                if(arr[j]%2 == 1){
                    
                    arr[j]--;
                    ans++;
                }
                
            }
            
        }
        
    }
}