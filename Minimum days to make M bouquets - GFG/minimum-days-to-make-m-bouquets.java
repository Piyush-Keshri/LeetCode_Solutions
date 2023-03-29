//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
       
       if(M*K > bloomDay.length){
           return -1;
       }
       
       int ans = -1;
       int start = Integer.MAX_VALUE;
       int end = Integer.MIN_VALUE;
       
       for(int x:bloomDay){
           
           start = Math.min(start,x);
           end = Math.max(end,x);
       }
       
       while(start<=end){
           
           int mid = start+(end-start)/2;
           
           if(valid(bloomDay,mid,M,K)){
               ans = mid;
               end = mid-1;
           }
           else{
               start = mid+1;
           }
       }
       return ans;
    }
    
    public static boolean valid(int[] bloomDay,int mid,int M,int K){
        
        int flowers =0;
        int bouquets = 0;
        
        for(int x : bloomDay){
            
            if(x<=mid){
                flowers++;
            }
            else{
                flowers = 0;
            }
            
            if(flowers == K){
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets >= M;
    }
    
}











