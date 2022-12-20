class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        int[] vis = new int[rooms.size()];
        Arrays.fill(vis,-1);
        
        q.add(0);
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            if(vis[node] != -1){
                continue;
            }
            
            vis[node] = 1;
            
            for(int it : rooms.get(node)){
                if(vis[it] == -1){
                    q.add(it);
                }
            }
        }
        
        for(int i = 0 ;i<rooms.size();i++){
            if(vis[i] == -1){
                return false;
            }
        }
        return true;
        
    }
}