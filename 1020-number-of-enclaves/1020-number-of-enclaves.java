class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        
        int[][] vis = new int[n][m];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
//         Traversing First And Last Row
        for(int i=0;i<m;i++){
            
//             First Row
            if(grid[0][i] == 1 && vis[0][i] == 0){
                dfs(0,i,n,m,grid,vis,delRow,delCol);
            }
            
//             Last Row
            if(grid[n-1][i] == 1 && vis[n-1][i] == 0){
                dfs(n-1,i,n,m,grid,vis,delRow,delCol);
            }
            
        }
        
//         Traversing First And Last Column
        for(int i=0;i<n;i++){
            
//             First Col
            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i,0,n,m,grid,vis,delRow,delCol);
            }
            
//             Last Col
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(i,m-1,n,m,grid,vis,delRow,delCol);
            }
            
        }
        
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
                
            }
        }
        
        return cnt;
    }
    
    public void dfs(int row,int col,int n,int m,int[][] grid,int[][] vis,int[] delRow,int[] delCol){
        
        vis[row][col] = 1;
        
        for(int i=0;i<4;i++){
            
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                
                dfs(nrow,ncol,n,m,grid,vis,delRow,delCol);
                
            }
            
        }
        
    }
    
}