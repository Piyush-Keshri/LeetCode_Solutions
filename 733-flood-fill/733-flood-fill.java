class Solution {
    
        public void dfs(int row,int col,int[][]ans,int[][]image,int newColor, int[]delRow,int[]delCol,int iniColor){
        
//         Change the iniColor to newColor
        ans[row][col] = newColor;
        
        int n = image.length;
        int m = image[0].length;
        
        for(int i =0;i<4;i++){
            
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && image[newRow][newCol]== iniColor && ans[newRow][newCol] != newColor){
                dfs(newRow,newCol,ans,image,newColor,delRow,delCol,iniColor);
            }
            
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
        int iniColor = image[sr][sc];
        int [][] ans = image;
        
        int []delRow = {-1,0,1,0};
        int []delCol = {0,1,0,-1};
        
        dfs(sr,sc,ans,image,newColor,delRow,delCol,iniColor);
        return ans;
    }
    

    
}