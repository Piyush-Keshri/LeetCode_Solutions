class Solution {
    
    
    public boolean dfs(int node,ArrayList<List<Integer>> adj,int[] vis,int[] pathVis,int[] check){
        
        vis[node] = 1 ;
        pathVis[node] = 1 ;
        check[node] = 0;

    for(Integer it:adj.get(node)){
        
        if(vis[it] == 0){
        if(dfs(it,adj,vis,pathVis,check) == true)
            return true;
        }
        
        else if(pathVis[it] == 1){
            return true;
        }
        
    }
    
        pathVis[node] = 0;
        check[node] = 1;
        return false;
        
    }
    
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
     ArrayList<List<Integer>> adj  = new ArrayList<List<Integer>>();
       
        
        for(int i=0;i<graph.length;i++){
            
            adj.add(new ArrayList<Integer>());
            for(int j=0;j<graph[i].length;j++){
                
                adj.get(i).add(graph[i][j]);
                
            }
        }
        
        int[] vis = new int[graph.length];
        int[] pathVis = new int [graph.length];
        int[] check = new int[graph.length];
        
        for(int i =0;i<graph.length;i++){
            
            if(vis[i] == 0){
                dfs(i,adj,vis,pathVis,check);
            }
            
        }
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<graph.length;i++){
            if(check[i] == 1){
                ans.add(i);
            }
            
        }
        return ans;
    }
}