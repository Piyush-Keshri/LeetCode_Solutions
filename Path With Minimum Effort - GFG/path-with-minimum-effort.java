//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Tuple{
    
    int distance;
    int row;
    int col;
    
    public Tuple(int distance,int row,int col){
        
        this.distance = distance;
        this.row = row;
        this.col = col;
        
    }
    
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
        
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        
        for(int i = 0;i<n;i++){
            
            for(int j= 0;j<m;j++){
                
                dist[i][j] = Integer.MAX_VALUE;
                
            }
            
        }
        
        dist[0][0] = 0;
        
        pq.add(new Tuple(0,0,0));
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        while(pq.size() != 0){
            
            Tuple it = pq.peek();
            pq.remove();
            
            int diff = it.distance;
            int row = it.row;
            int col = it.col;
            
            if(row == n-1 && col == m-1){
                return diff;
            }
            
            for(int i=0;i<4;i++){
                
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                    
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]),diff);
                    
                    if(effort<dist[nrow][ncol]){
                        
                        dist[nrow][ncol] = effort;
                        pq.add(new Tuple(effort,nrow,ncol));
                        
                    }
                    
                }
                
                
            }
            
        }
        return 0;
    }
}