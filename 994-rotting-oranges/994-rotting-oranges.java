class Node{
    int first;
    int second;
    int time;

    Node(int first,int second,int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        Queue<Node> q = new LinkedList<Node>();
        
        int cntFresh = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 2){
                    q.add(new Node(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1){
                    cntFresh++;
                }
                
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        int tm = 0;
        int cnt = 0;
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            
            tm = Math.max(tm,t);
            q.remove();
            
            for(int i = 0;i<4;i++){
                
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    
                    q.add(new Node(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                    
                }
                
            }
            
        }
        if(cnt!=cntFresh){
             return -1;
        }
        return tm;
    }
}