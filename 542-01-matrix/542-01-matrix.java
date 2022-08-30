class Node{
    int first; int second; int dist;
    Node(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
    int n = mat.length;
    int m = mat[0].length;
    
        int[][] vis = new int [n][m];
        int[][] dist = new int[n][m];
        
        Queue<Node> q = new LinkedList<Node>();
        
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.add(new Node(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
    
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().dist;
            
            dist[row][col] = steps;
            q.remove();
            for(int i=0 ; i<4; i++){
                
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0){
                    
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow,ncol,steps+1));
                    
                }
                
            }
        }
        return dist;
    }
}