class Pair{
    
    int row;int col;int steps;
    
    Pair(int row,int col,int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
    
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0,1));
        
       int target_row = grid.length - 1;
       int target_col = grid[0].length -1;
        
        while(!q.isEmpty()){
            
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            
            q.remove();
            
            if(row >=0 && col>= 0 && row< grid.length && col<grid[0].length && grid[row][col] != 1){
                
                grid[row][col] = 1;
                
                if(row == target_row && col == target_col){
                    return steps;
                }
                
                q.add(new Pair(row-1,col-1,steps+1));
                q.add(new Pair(row-1,col,steps+1));
                q.add(new Pair(row-1,col+1,steps+1));
                q.add(new Pair(row,col-1,steps+1));
                q.add(new Pair(row,col+1,steps+1));
                q.add(new Pair(row+1,col-1,steps+1));
                q.add(new Pair(row+1,col,steps+1));
                q.add(new Pair(row+1,col+1,steps+1));
                
            }
            
        }
        return -1;
    }
}