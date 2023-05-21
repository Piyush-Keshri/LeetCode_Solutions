class Pair{
    int row;
    int col;
    
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
    
}

class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};
        
        boolean flag = false;
        
        for(int i=0;i<n && !flag;i++){
            
            for(int j=0;j<m && !flag;j++){
                
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    dfs(i,j,grid,vis,q,delRow,delCol);
                    flag = true;
                }
                
            }
            
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size -- >0){
                Pair node = q.poll();
                int row = node.row;
                int col = node.col;
                vis[row][col] = 1;
                
                for(int i=0;i<4;i++){
                    
                    int nrow = row+delRow[i];
                    int ncol = col+delCol[i];
                    
                    if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol] == 0){
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol]=1;
                        if(grid[nrow][ncol] == 1)
                            return cnt;
                    }
                    
                    
                }
                
            }
            cnt++;
        }
        return -1;
        
    }
        public static void dfs(int row,int col,int[][] grid,int[][] vis,Queue<Pair>q,int[] delRow,int[] delCol)         {
            
            int n = grid.length;
            int m = grid[0].length;
            
            q.add(new Pair(row,col));
            vis[row][col] = 1;
            
            for(int i=0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && grid[nrow][ncol] == 1){
                    dfs(nrow,ncol,grid,vis,q,delRow,delCol);
                }
                
            }
            
            
            
        }
}