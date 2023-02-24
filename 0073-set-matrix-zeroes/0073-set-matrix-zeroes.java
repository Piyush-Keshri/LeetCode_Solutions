class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] matrix2 = new int[rows][cols];
        
         for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                matrix2[i][j]=matrix[i][j];
        }
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                
                if(matrix[i][j] == 0){
                    
                    for(int k =0;k<rows;k++){
                        matrix2[k][j] = 0;
                    }
                    for(int k =0;k<cols;k++){
                        matrix2[i][k] = 0;
                    }
                }
                
            }
        }
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                
                matrix[i][j] = matrix2[i][j];
                
            }
        }
        
    }
}