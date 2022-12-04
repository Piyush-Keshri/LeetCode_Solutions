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
   ArrayList<String> ls = new ArrayList<String>();
   
   String p = "";
   
   return generate(p,n,ls);
  }
  
  public static List<String> generate(String p,int n, ArrayList<String> ls){
      
      if(n==0){
          ls.add(p);
          return ls;
      }
      
      if(p.endsWith("1")){
          generate(p+'0',n-1,ls);
      }
      else{
          generate(p+'0',n-1,ls);
          generate(p+'1',n-1,ls);
      }
      return ls;
  } 
  
}
     
     