//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends

class Pair{
    int distance;int node;
    public Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}

class Solution
{
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        
        int[] vis = new int[V];
        pq.add(new Pair(0,0));
        
        int sum = 0;
        while(!pq.isEmpty()){
            
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            if(vis[node] == 1){
                continue;
            }
            vis[node] = 1;
            sum+=wt;
            
            for(int i = 0;i<adj.get(node).size();i++){
                
                int adjNode = adj.get(node).get(i).get(0);
                int edjWt = adj.get(node).get(i).get(1);
                
                if(vis[adjNode] == 0){
                    pq.add(new Pair(edjWt,adjNode));
                } 
            }   
            
        }
        
        return sum;
    }
}
