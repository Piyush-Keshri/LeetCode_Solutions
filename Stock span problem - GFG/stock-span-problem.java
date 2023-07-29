//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends

class Pair{
    
    int ele;
    int indx;
    
    public Pair(int ele,int indx){
        this.ele = ele;
        this.indx = indx;
    }
}

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Pair> st = new Stack<>();
        
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            
            if(st.isEmpty()){
                ans[i] = -1; 
            }
            
            while(!st.isEmpty() && st.peek().ele <= price[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(st.peek().ele > price[i]){
                ans[i] = st.peek().indx;
            }
            
            st.add(new Pair(price[i],i));
        }
        
        for(int i=0;i<n;i++){
            
            ans[i] = i-ans[i];
            
        }
        return ans;
    }
    
}