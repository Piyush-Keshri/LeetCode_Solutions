//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int findKRotation(int nums[], int n) {
    
        int lo = 0;
        int hi = n-1;
        
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
        
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            
            if(nums[mid] <= nums[prev] && nums[mid]<= nums[next]){
                return mid;
            }
            else if(nums[mid]<nums[hi]){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return 0;
    
    }
}