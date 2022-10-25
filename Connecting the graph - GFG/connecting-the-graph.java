//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans = obj.Solve(n,edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
        parent.add(i);
        size.add(1);
    }
        
    }
    
    
    public int findUParent(int node){
        
        if(parent.get(node) == node){
            return node;
        }
        
        int ultP = findUParent(parent.get(node));
        parent.set(node,ultP);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        
        int ultp_u = findUParent(u);
        int ultp_v = findUParent(v);
        
        if(ultp_u == ultp_v){
            return;
        }
        
        if(size.get(ultp_u) < size.get(ultp_v)){
            
            parent.set(ultp_u,ultp_v);
            size.set(ultp_v,size.get(ultp_u) + size.get(ultp_v));
        }
        else{
            parent.set(ultp_v,ultp_u);
            size.set(ultp_u,size.get(ultp_v) + size.get(ultp_u));
            
        }
        
    }
        
}
class Solution {
    
    public int Solve(int n, int[][] edge) {
     
     DisjointSet ds = new DisjointSet(n);
     int m = edge.length;
     int extraEdges = 0;
     
     for(int i=0 ;i<m ;i++){
         
         int u = edge[i][0];
         int v = edge[i][1];
         
        if(ds.findUParent(u) == ds.findUParent(v)){
            extraEdges++;
        }
        else{
            ds.unionBySize(u,v);
        }
         
     }
     
     int countComponents = 0;
     
     for(int i = 0;i<n;i++){
         
         if(ds.parent.get(i) == i){
             countComponents++;
         }
     }
     
     int ans = countComponents - 1;
     
     if(ans <= extraEdges){
         return ans;
     }
     return -1;
    
    }
}