class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> rowset = new HashSet<>();
            HashSet<Integer> colset = new HashSet<>();
            for(int j=0;j<n;j++){
                rowset.add(matrix[i][j]);
                colset.add(matrix[j][i]);
            }
            if(rowset.size() != n || colset.size() != n){
                return false;
            }
        }
        
        return true;
    }
}