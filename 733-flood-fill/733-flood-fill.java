class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
        int inicolor = image[sr][sc];
        
        int[][] ans = image;
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1}; 
    
        dfs(sr,sc,inicolor,color,image,ans,delRow,delCol);
        return ans;
    }
    
    public void dfs(int row,int col,int inicolor,int newcolor,int[][] image,int[][] ans,int[] delRow,int[] delCol)
    {
        ans[row][col] = newcolor;
        
        int n = image.length;
        int m = image[0].length;
        
        for(int i=0;i<4;i++){
            
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol] == inicolor && ans[nrow][ncol]!= newcolor){
                
                dfs(nrow,ncol,inicolor,newcolor,image,ans,delRow,delCol);
                
            }
            
        }
        
    }

}