class Node{
    int row;
    int col;
    int dist;
    
    Node(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
    
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new Node(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().dist;
            ans[row][col] = steps;
            
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0  && ncol<m && vis[nrow][ncol] == 0){
                            vis[nrow][ncol] = 1; 
                    q.add(new Node(nrow,ncol,steps+1));
                    
                }
            }        
        }
        return ans;
    }
}