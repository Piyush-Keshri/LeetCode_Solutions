class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        int a = y2-y1;
        int b = x1-x2;
        
        int c = a*x1 + b*y1;
        
        for(int i=2;i<coordinates.length;i++){
            
            int slope = a * coordinates[i][0] + b * coordinates[i][1];
            
            if(slope != c){
                return false;
            }
            
        }
        return true;
    }
}