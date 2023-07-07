class Solution {
    public void rotate(int[][] matrix) {
     int n = matrix.length;   
//         Transpose
        
        for(int i=0;i<n;i++){
            
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            
        }
     // Reverse Rows
        
        for(int[] rows:matrix){
            
            reverse(rows,0,n-1);
            
        }
        
    }
    
    public void reverse(int[] row,int st,int end){
        
        while(st<end){
            int temp = row[st];
            row[st] = row[end];
            row[end] = temp;
            st++;
            end--;
        }
        
    }
    
}