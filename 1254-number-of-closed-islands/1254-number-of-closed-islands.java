class Solution {
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n]; 
        int island = 0;
        
        for(int i = 0;i<m;i++){
            
            for(int j=0;j<n;j++){
                
                if(grid[i][j] == 0 && !vis[i][j] && bfs(i,j,m,n,grid,vis)){
                    island++;
                }
                
            }
            
        }
        return island;
    }
    
    public boolean bfs(int row,int col,int m,int n,int[][] grid,boolean[][] vis){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        vis[row][col] = true;
        boolean isClosed = true;
        
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            row = temp[0];
            col = temp[1];
            
            for(int i=0;i<4;i++){
                
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                
                if(nrow<0 || ncol<0 || nrow>m-1 || ncol>n-1){
                    isClosed = false;
                }
                else if(grid[nrow][ncol] == 0 && !vis[nrow][ncol]){
                    q.offer(new int[]{nrow,ncol});
                    vis[nrow][ncol] = true;
                }
                
            }
            
        }
        return isClosed;
    }
    
}











