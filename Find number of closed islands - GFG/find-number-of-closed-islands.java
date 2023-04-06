//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] grid, int N, int M)
    {
        
        boolean[][] vis = new boolean[N][M];
        int island = 0;
        
        for(int i=0;i<N;i++){
            
            for(int j=0;j<M;j++){
                
                if(grid[i][j] == 1 && !vis[i][j] && bfs(i,j,N,M,grid,vis)){
                    island++;
                }
                
            }
            
        }
        return island;
    }
    
    
    public boolean bfs(int row,int col,int N,int M,int[][] grid,boolean[][] vis){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        
        boolean isClosed = true;
        
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            
            row = temp[0];
            col = temp[1];
            
            for(int i =0;i<4;i++){
                
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                
                if(nrow<0 || ncol<0 || nrow>N-1 || ncol>M-1){
                    
                    isClosed = false;
                }
                else if(grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    
                    q.offer(new int[]{nrow,ncol});
                    vis[nrow][ncol]  = true;
                }
            }
        }
        
        return isClosed;
    }

}









