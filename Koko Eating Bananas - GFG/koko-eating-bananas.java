//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        
        int max = Integer.MAX_VALUE;
        
        for(int x:piles){
            max = Math.max(max,x);
        }
        
        int start = 1;
        int end = max;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(valid(piles,mid,H)){
                end = mid-1;
            }
            
            else{
                start = mid+1;
            }
            
        }
        return start;
    }
    
    public static boolean valid(int[] piles,int mid,int H){
        
        long hours = 0;
        
        for(int x:piles){
            
            int n = x/mid;
            hours += n;
            
            if(x%mid != 0){
                hours++;
            }
            
        }
        return (hours <= H);
    }
    
}
        
