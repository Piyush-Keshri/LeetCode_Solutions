class Tuple{
    
    int row;
    int col;
    int steps;
    public Tuple(int row,int col,int steps){
         
        this.row = row;
        this.col = col;
        this.steps = steps;
    } 
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        Queue<Tuple>pq = new LinkedList<>();
        pq.add(new Tuple(0,0,1));
        
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        int[] dir = {1,1,0,1,-1,-1,0,-1};
        int[] dic = {1,0,1,-1,1,0,-1,-1};
        
        while(!pq.isEmpty()){
            
            Tuple tup = pq.poll();
            int row = tup.row;
            int col = tup.col;
            int steps = tup.steps;
            
            if(row == n-1 && col == n-1){
                return steps;
            }
            for(int i=0;i<8;i++){
                
                int nrow = row+dir[i];
                int ncol = col+dic[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 0){
                    
                    pq.add(new Tuple(nrow,ncol,steps+1));
                    vis[nrow][ncol] = 1;
                }
                
            }            
            
        }
        return -1;
    }
}













