//{ Driver Code Starts
//Initial Template for Java

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
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends
class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        
        for(int i = 0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
        
    }
    
    public int findUParent(int node){
        
        if(node == parent.get(node)){
            return node;
        }
        
        int ultP = findUParent(parent.get(node));
        parent.set(node,ultP);
        return parent.get(node);
        
    }
    
    public void unionBySize(int u,int v){
        
        int ultP_u = findUParent(u);
        int ultP_v = findUParent(v);
        
        if(ultP_u == ultP_v){
            return;
        }
        
        if(size.get(ultP_u) < size.get(ultP_v)){
            
            parent.set(ultP_u,ultP_v);
            size.set(ultP_v,size.get(ultP_u) + size.get(ultP_v));
        }
        else{
            parent.set(ultP_v,ultP_u);
            size.set(ultP_u,size.get(ultP_u) + size.get(ultP_v));
        }
        
    }
    
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    
    for(int i=0;i<n;i++){
        
        for(int j = 1;j<accounts.get(i).size();j++){
            String mail = accounts.get(i).get(j);
            if(map.containsKey(mail) == false){
                map.put(mail,i);
            }
            else{
                
                ds.unionBySize(i,map.get(mail));
            }
            
        }
        
    }
    
  ArrayList<String>[] mergedMail = new ArrayList[n];
    
    for(int i = 0;i<n;i++){
        mergedMail[i] = new ArrayList<String>();
    }
    
    for(Map.Entry<String,Integer> it : map.entrySet()){
        
        String mail = it.getKey();
        int node = ds.findUParent(it.getValue());
        mergedMail[node].add(mail);
    }
    
    List<List<String>> ans = new ArrayList<>();
    
    for(int i=0;i<n;i++){
        
        if(mergedMail[i].size() == 0) continue;
        Collections.sort(mergedMail[i]);
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String it:mergedMail[i]){
            temp.add(it);
            
        }
        ans.add(temp);
    }
    return ans;
  }
}
     