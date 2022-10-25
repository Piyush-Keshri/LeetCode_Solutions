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
            size.set(ultP_u,size.get(ultP_v) + size.get(ultP_u)); 
        }
    }
    
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds  = new DisjointSet(n);
        int m = connections.length;
        int extraConn = 0;
        
        for(int  i = 0;i<m; i++){
            
            int  u = connections[i][0];
            int v = connections[i][1];
            
            if(ds.findUParent(u) == ds.findUParent(v)){
                extraConn++;
            }
             else{
                 ds.unionBySize(u,v);
             }
        }
        
        int noNetworks = 0 ;
        
        for(int i=0;i<n;i++){
            
            if(ds.parent.get(i) == i){
                
                noNetworks++;
            }
        }
        
        int ans = noNetworks-1;
        if(ans<= extraConn) return ans;
        return -1;
    }
}