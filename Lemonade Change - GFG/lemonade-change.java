//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
       
       int cnt5=0;int cnt10=0;
       
       for(int i=0;i<bills.length;i++){
           
           if(bills[i] == 5){
               cnt5++;
           }
           
           else if(bills[i] == 10){
               if(cnt5<1) return false;
               cnt5--;
               cnt10++;
           }
           
           else{
               
               if(cnt5>0 && cnt10>0){
                cnt5--;
                cnt10--;
           }
           
           else if(cnt5>2){
               cnt5-=3;
           }
           else return false;
       }
       
    }
    return true;
}
}