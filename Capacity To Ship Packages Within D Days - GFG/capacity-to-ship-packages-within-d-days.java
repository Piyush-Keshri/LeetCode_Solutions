//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        
        int start = 0;
        int end = 0;
        
        int ans = 0;
        
        for(int x:arr){
            start = Math.max(x,start);
            end +=x;
        }
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(valid(arr,mid,D)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            
        }
        
        return ans;
    }
    
    public static boolean valid(int[] arr,int mid,int D){
        
        int weight = 0;
        int days = 1;
        
        for(int x:arr){
            weight+=x;
            
            if(weight>mid){
                days++;
                weight = x;
            }
        }
        return days<=D;
    }
    
};

















