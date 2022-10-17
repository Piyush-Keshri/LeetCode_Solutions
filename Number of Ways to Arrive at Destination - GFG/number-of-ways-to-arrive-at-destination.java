//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
       List<List<int[]>> adj = new ArrayList<>();
       
       for(int i = 0;i<n;i++){
           
           adj.add(new ArrayList<int[]>());
       }
       
       for(int i=0;i<roads.size();i++){
           
           int u = roads.get(i).get(0);
           int v = roads.get(i).get(1);
           int wt = roads.get(i).get(2);
           
           adj.get(u).add(new int[]{v,wt});
           adj.get(v).add(new int[]{u,wt});
           
       }
       
       int[] dist = new int[n];
       int[] ways = new int[n];
       Arrays.fill(dist,(int)1e9);
       Arrays.fill(ways,0);
       
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
       pq.add(new int[]{0,0});
       
       dist[0] = 0;
       ways[0] = 1;
       int mod = (int)1e9 + 7;
       
       while(!pq.isEmpty()){
           
           int[] p= pq.remove();
           int currNode = p[0];
           int currWt = p[1];
           
            for(int[] it : adj.get(currNode)){
                
                int adjNode = it[0];
                int adjWt = it[1];
                
                if(currWt + adjWt < dist[adjNode]){
                    
                    dist[adjNode] = currWt+adjWt;
                    ways[adjNode] = ways[currNode];
                    pq.add(new int[]{adjNode,currWt+adjWt});
                    
                }
                else if(currWt+adjWt == dist[adjNode]){
                    
                    ways[adjNode] = (ways[adjNode]+ways[currNode]) % mod;
                    
                }
                
            }    
           
       }
       return ways[n-1];
    }
}
