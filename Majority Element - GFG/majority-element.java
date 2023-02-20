//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        int count = 0;
        int cand = 0;
        
        for(int x:a){
            if(count == 0){
                cand = x;
            }
            
            if(x == cand){
                count++;
            }
            else
            count--;
        }
       int c = 0;
       for(int i =0;i<size;i++){
           
           if(a[i] == cand){
               c++;
           }
       }
       
       return (c>size/2)?cand:-1;
       
    }
}