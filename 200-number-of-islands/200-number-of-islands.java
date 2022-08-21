class Pair{
    int first;
    int second;
    
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
    
}

class Solution {
    
    public void bfs(int ro,int co,char[][] grid,int[][] vis){
    
    vis[ro][co] = 1;
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(ro,co));

    int n = grid.length;
    int m = grid[0].length;

    int[] delRow = {-1,0,1,0};
    int[] delCol = {0,1,0,-1};
    
    while(!q.isEmpty()){
        
        int row = q.peek().first;
        int col = q.peek().second;
        q.remove();
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int nrow = row+delRow[i];
                int ncol = col + delCol[i];
                
    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow,ncol));
    }
                            
            }
        }
        
    }
    
    
}
    
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        
        int[][] vis = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(i,j,grid,vis);
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
}