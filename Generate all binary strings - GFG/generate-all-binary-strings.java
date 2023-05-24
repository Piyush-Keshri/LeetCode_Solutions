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
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
 
        List<String> res = new ArrayList<>();
        String s = "";
        
        solve(n,s,res);
        return res;
  }
  
  public static void solve(int n,String s,List<String>res){
      
      if(n == 0){
          res.add(s);
          return;
      }
      
      if(s.endsWith("1")){
          solve(n-1,s+"0",res);
      }
      else{
          solve(n-1,s+"0",res);
          solve(n-1,s+"1",res);
      }
      
      
  }
  
}
     
     