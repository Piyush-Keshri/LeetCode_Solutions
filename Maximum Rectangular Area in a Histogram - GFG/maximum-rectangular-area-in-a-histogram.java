//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends

class Pair{
    long ele;
    long indx;
    
    public Pair(long ele,long indx){
        this.ele = ele;
        this.indx = indx;
    }
}

class Solution
{
    
    public static long[] nsl(long hist[],long n){
        
        long[] ans = new long[hist.length];
        
        Stack<Pair> st = new Stack<>(); 
        
        for(int i=0;i<n;i++){
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            
            while(!st.isEmpty() && st.peek().ele >= hist[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(st.peek().ele < hist[i]){
                ans[i] = st.peek().indx;
            }
            
            st.push(new Pair(hist[i],i));
        }
        
        for(int i=0;i<n;i++){
            
            ans[i] = i-ans[i];
            
        }    
        return ans;
    }
     
     
     public static long[] nsr(long hist[],long n){
        
        long[] ans = new long[hist.length];
        
        Stack<Pair> st = new Stack<>(); 
        
        for(int i= hist.length-1;i>=0;i--){
            
            if(st.isEmpty()){
                ans[i] = n;
            }
            
            while(!st.isEmpty() && st.peek().ele >= hist[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = n;
            }
            else if(st.peek().ele < hist[i]){
                ans[i] = st.peek().indx;
            }
            
            st.push(new Pair(hist[i],i));
        }
        
        for(int i=0;i<ans.length;i++){
            
            ans[i] = ans[i] - i;
            
        }
        
        return ans;
    }
     
    
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
       
       long[] arr1 = nsl(hist,n);
       long[] arr2 = nsr(hist,n);
       
    //   System.out.println(Arrays.toString(arr1));
    //   System.out.println(Arrays.toString(arr2));
       
       long ans = Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
           long area = hist[i] * (arr2[i] + arr1[i]-1);
           ans = (long)Math.max(area,ans);
       }
       return ans;
    }
        
}



