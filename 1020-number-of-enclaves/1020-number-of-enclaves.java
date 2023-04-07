class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<m;i++){
            
//             First row
            if(grid[0][i] == 1 && !vis[0][i]){
                bfs(0,i,n,m,grid,vis);
            }
            
//             Last Row
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                bfs(n-1,i,n,m,grid,vis);
            }
        }
        
        for(int i=0;i<n;i++){
            
//             First Column
            if(grid[i][0] == 1 && !vis[i][0]){
                bfs(i,0,n,m,grid,vis);
            }
            
//             Last Column
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                bfs(i,m-1,n,m,grid,vis);
            }
            
        }
        int count =0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
                
            }
        }
        return count;
    }
    
    public void bfs(int row,int col,int n,int m,int[][] grid,boolean[][] vis){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        vis[row][col] = true;
        
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            row = temp[0];
            col = temp[1];
            
            for(int i=0;i<4;i++){
                
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                
                if(nrow<0 || ncol<0 || nrow>n-1 || ncol>m-1){
                    continue;
                }
                else if(grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    q.offer(new int[]{nrow,ncol});
                    vis[nrow][ncol] = true;
                }
            }
            
           
        }
         return;
    }
    
}