//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
      
      int[][] dp = new int[n][n];
      
      for(int[] row:dp){
          Arrays.fill(row,Integer.MAX_VALUE);
      }
      
      return memoization(grid,0,0,dp);
    }
    
    public static int memoization(ArrayList<ArrayList<Integer>>grid,int row,int col,int[][] dp){
        
        if(row == grid.size()){
            return 0;
        }
        
        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        
        int traverse = Math.min(memoization(grid,row+1,col,dp),memoization(grid,row+1,col+1,dp));
        
        dp[row][col] = grid.get(row).get(col) + traverse;
        return dp[row][col];
    }
    
}