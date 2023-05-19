//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        Arrays.sort(a);
        solve(0,a,s,ls,res);
        
        return res;
    }
    
    public static void solve(int indx,int[] a,int target,List<Integer> ls,List<List<Integer>> res){
        
        if(target == 0){
            res.add(new ArrayList<>(ls));
        }
        
        for(int i=indx;i<a.length;i++){
            
            if(i>indx && a[i] == a[i-1]) continue;
            
            if(target < a[i]) break;
            
            ls.add(a[i]);
            solve(i+1,a,target-a[i],ls,res);
            ls.remove(ls.size()-1);
        }
    }
    
}