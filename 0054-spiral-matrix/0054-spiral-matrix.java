class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int minrow = 0;
        int mincol = 0;
        int maxrow = n-1;
        int maxcol = m-1;
        
        
        while(minrow<=maxrow && mincol<=maxcol){
            
//             Right Traversal
            for(int i=mincol;i<=maxcol;i++){
                ans.add(matrix[minrow][i]);
            }
            minrow++;
            
//             Down Traversal
            for(int i=minrow;i<=maxrow;i++){
                ans.add(matrix[i][maxcol]);
            }
            maxcol--;
            
//            Left Traversal
            if(minrow<=maxrow){
            for(int i=maxcol;i>=mincol;i--){
                ans.add(matrix[maxrow][i]);
            }
        }
            maxrow--;
            
//             Up Traversal
            if(mincol<=maxcol){
            for(int i=maxrow;i>=minrow;i--){
                ans.add(matrix[i][mincol]);
            }
        }
            mincol++;
        }
        
        return ans;
    }
}














