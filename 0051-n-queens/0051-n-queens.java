class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                board[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        solve(0,board,res);
        
        return res;
        
    }
    
    public void solve(int col,char[][] board,List<List<String>>res){
        
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            
            if(validate(board,row,col)){
                board[row][col] = 'Q';
                solve(col+1,board,res);
                board[row][col] = '.';
            }
            
        }
        
    }
    
    public List<String> construct(char[][] board){
        List<String> ls = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            
            String s = new String(board[i]);
            ls.add(s);
        }
        return ls;
    }
    
    public boolean validate(char[][] board,int row,int col){
        
        int temprow= row;
        int tempcol = col;
        
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q')
                return false;
            
            row--;
            col--;
        }
        
        row = temprow;
        col = tempcol;
        
        while(col>=0){
            if(board[row][col] == 'Q')
                return false;
            
            col--;
        }
        
        row = temprow;
        col = tempcol;
        
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q')
                return false;
            
            row++;
            col--;
        }
        
        return true;
    }
}