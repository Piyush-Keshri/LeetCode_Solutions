class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
//         Form graph
        ArrayList<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
//         Find indegree of each node
      int[] indegree = new int[n]; 
        for(int i=0;i<n;i++){
            
            for(Integer it:adj.get(i)){
                
                indegree[it]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0 ;i< n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<Integer>();
        
        while(!q.isEmpty()){
            
            int node = q.peek();
            q.remove();
            topo.add(node);
            
            for(Integer it : adj.get(node)){
                indegree[it]--;
            
                if(indegree[it] == 0){
                    q.add(it);
                }
                
            }

        }
        
        if(topo.size() == n) return true;
        return false;
        
    }
}