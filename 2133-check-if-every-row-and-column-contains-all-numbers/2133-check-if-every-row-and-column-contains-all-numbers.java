class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> rowset = new HashSet<>();
            
            for(int j=0;j<n;j++){
                rowset.add(matrix[i][j]);
            }
            if(rowset.size() != n){
                return false;
            }
        }
        
        for(int i=0;i<n;i++){
            HashSet<Integer> colset = new HashSet<>();
            
            for(int j=0;j<n;j++){
                colset.add(matrix[j][i]);
            }
            if(colset.size() != n){
                return false;
            }
        }
        return true;
    }
}