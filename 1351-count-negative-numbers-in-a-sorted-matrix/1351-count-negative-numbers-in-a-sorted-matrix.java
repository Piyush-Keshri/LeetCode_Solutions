class Solution {
    public int countNegatives(int[][] grid) {
        int cnt =0 ;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]<0){
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
}