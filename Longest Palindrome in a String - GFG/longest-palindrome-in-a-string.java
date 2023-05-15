//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        
        if(S.length() < 2){
            return S;
        }
        
        String res = "";
        
        for(int i=0;i<S.length();i++){
            
            String odd = getPalindrome(S,i,i);
            
            if(odd.length() > res.length()){
                res = odd;
            }
            String even = getPalindrome(S,i,i+1);
            
            if(even.length() > res.length()){
                
                res = even;
            }
        }
        
        return res;
        
    }
    
    public static String getPalindrome(String str,int start,int end){
        
        while(start>=0 && end<str.length() && str.charAt(start) == str.charAt(end)){
        
                start--;
                end++;
            
        }
    return str.substring(start+1,end);
}
}