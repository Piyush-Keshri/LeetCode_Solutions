//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        
        for(int i=0;i<n;i++){
            
            for(int space = 0;space<n-i-1;space++){
                
                System.out.print(" ");
            }
            for(int star = 0;star<2*i+1;star++){
                System.out.print("*");
            }
            // for(int space = 0;space<n-i-1;space++){
                
            //     System.out.print(" ");
            // } 
            System.out.println();
        }
       
    }
}