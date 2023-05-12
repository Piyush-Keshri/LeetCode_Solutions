//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        
        int res = 0;
        
        for(int i=0;i<s.length()-1;i++){
            
            int a= getValue(s.charAt(i));
            int b = getValue(s.charAt(i+1));
            
            if(a<b){
                res-=a;
            }
            else{
                res+=a;
            }
        }
        return res+=getValue(s.charAt(s.length()-1));
    }
    
    public int getValue(char ch){
        
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else return 1000;
         
    }
    
}