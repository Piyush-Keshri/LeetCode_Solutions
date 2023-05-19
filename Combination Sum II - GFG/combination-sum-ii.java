//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String s[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int a[] = new int[n];
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(s[i]);
			List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
			for(List<Integer> list : ans){
				for(int x : list)
					ot.print(x + " ");
				ot.println();
			}
			if(ans.size() == 0)
			    ot.println();
		}
        ot.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	public List<List<Integer>> CombinationSum2(int a[], int n, int k){
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		Arrays.sort(a);
		solve(0,a,n,k,ls,res);
		
		return res;
	}
	
	public void solve(int indx,int[] arr,int n,int target,List<Integer> ls,List<List<Integer>>res){
	    
	    
	    
	        if(target == 0){
	            res.add(new ArrayList<>(ls));
	        return ;
	        }
	    
	    for(int i=indx;i<n;i++){
	        
	        if(i>indx && arr[i] == arr[i-1]) continue;
	        if(target< arr[i]) break;
	        ls.add(arr[i]);
	        solve(i+1,arr,n,target-arr[i],ls,res);
	        ls.remove(ls.size()-1);
	    }
	       
	}
}

