//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
     
     int cnt0=0,cnt1=0,cnt2=0;
     
     for(int i=0;i<n;i++){
         if(a[i] == 0){
             cnt0++;
         }
         if(a[i] == 1){
             cnt1++;
         }
         if(a[i] == 2){
             cnt2++;
         }
     }
     
     for(int i =0;i<n;i++){
         a[i] = 0;
     }
     for(int i =cnt0;i<n;i++){
         a[i] = 1;
     }
     for(int i =cnt0+cnt1;i<n;i++){
         a[i] = 2;
     }
     
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends