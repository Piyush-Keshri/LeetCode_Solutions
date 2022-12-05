//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
       
      List<String> ans = new ArrayList<String>();
      
      helper(ans,"",n,n);
      return ans;
       
    }
    
    public void helper(List<String> ans,String s,int left,int right){
        
        if(left>right){
            return;
        }
        
        if(left==0&&right==0){
            ans.add(s);
            return;
        }
        
        if(left>0){
            helper(ans,s+"(",left-1,right);
        }
        if(right>0){
            helper(ans,s+")",left,right-1);
        }
        
    }
    
}