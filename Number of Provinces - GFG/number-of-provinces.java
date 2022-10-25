//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends

class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        
        for(int i =0 ;i<n;i++){
            parent.add(i);
            rank.add(0);
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
    
    public void unionByRank(int u,int v){
        
        int ultp_u = findUParent(u);
        int ultp_v = findUParent(v);
        
        if(ultp_u == ultp_v){
            return;
        }
        
        if(rank.get(ultp_u) < rank.get(ultp_v)){
            parent.set(ultp_u,ultp_v);
        }
        
        else if(rank.get(ultp_v) < rank.get(ultp_u)){
            parent.set(ultp_v,ultp_u);
        }
        else{
            parent.set(ultp_v,ultp_u);
            int rankU = rank.get(ultp_u);
            rank.set(ultp_u,rankU+1);
        }
        
    }
    
    public void unionBySize(int u,int v){
        
        int ultp_u = findUParent(u);
        int ultp_v = findUParent(v);
        
        if(ultp_u == ultp_v) return;
        
        if(size.get(ultp_u) < size.get(ultp_v)){
            
            parent.set(ultp_u,ultp_v);
            size.set(ultp_v,size.get(ultp_u)+size.get(ultp_v));
        }
        else{
            parent.set(ultp_v,ultp_u);
            size.set(ultp_u,size.get(ultp_v)+size.get(ultp_u));
        }
        
    }
    
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
    
        DisjointSet ds = new DisjointSet(V);
        
        for(int i = 0 ;i<V;i++){
            for(int j =0 ;j<V;j++){
                
                if(adj.get(i).get(j) == 1){
                    ds.unionBySize(i,j);
                    
                }
                
            }
            
        }
        
        int cnt = 0;
        
        for(int  i= 0;i<V;i++){
            
            if(ds.parent.get(i) == i){
                cnt++;
            }
            
        }
        return cnt;
    }
};