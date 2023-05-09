class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] ans = new int[n][n];
        
        int minrow = 0;
        int maxrow = n-1;
        int mincol = 0;
        int maxcol = n-1;
        
        for(int i=1;i<=n*n;i++){
            
            while(minrow<=maxrow && mincol<=maxcol){
                
//                 Right Traversal
                for(int j=mincol;j<=maxcol;j++){
                    
                    ans[minrow][j] = i;
                    i++;
                }
                minrow++;
                
//                 Bottom Traversal
                for(int j=minrow;j<=maxrow;j++){
                    
                    ans[j][maxcol] = i;
                    i++;
                    
                }
                maxcol--;
                
//                 Left Traversal
                if(mincol<=maxcol){
                    for(int j=maxcol;j>=mincol;j--){
                    ans[maxrow][j] = i;  
                    i++;
                }
            }
             maxrow--;
                
//                 Up Traversal
                if(minrow<=maxrow){
                    for(int j=maxrow;j>=minrow;j--){
                        ans[j][mincol] = i;
                        i++;
                    }
                }
                mincol++;
        }
            
    }
        
        return ans;
    }
}