//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
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
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,ls,res);
        
        return res;
    }
    
    public static void solve(int indx,int[] nums,List<Integer>ls,ArrayList<ArrayList<Integer>> res){
        
        res.add(new ArrayList<>(ls));
        if(indx == nums.length){
            return;
        }
        
        for(int i=indx;i<nums.length;i++){
            
            if(i>indx && nums[i] == nums[i-1]) continue;
            
            ls.add(nums[i]);
            solve(i+1,nums,ls,res);
            ls.remove(ls.size()-1);
            
        }
        
    }
    
}